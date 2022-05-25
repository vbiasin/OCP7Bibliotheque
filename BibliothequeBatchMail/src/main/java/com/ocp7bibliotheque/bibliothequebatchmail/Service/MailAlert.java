package com.ocp7bibliotheque.bibliothequebatchmail.Service;

import com.ocp7bibliotheque.bibliothequebatchmail.DAO.LendingRepository;

import com.ocp7bibliotheque.bibliothequebatchmail.Entites.Lending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Service
@Transactional
public class MailAlert {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    LendingRepository lendingRepository;

    @Scheduled(fixedRate = 600000)
    public void mailDiffusor(){

        //appel au module BibliothequeBook
        List<Lending> lendings = lendingRepository.findAll() ;
        for (Lending lending:lendings) {
            if(lending.getEndDate().isBefore(LocalDateTime.now())){
                // Create a Simple MailMessage.
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(lending.getUserAccount().getMail());
                message.setSubject("Prêt en retard");
                message.setText("Bonjour, votre prêt "+lending.getBook().getTitle()+" effectué le " +lending.getStartDate()+" à la librairie: "
                        +lending.getBook().getLibrary().getName() + " est arrivé à échéance. Si ce n'est pas déjà le cas vous pouvez le prolonger dans votre espace personnelle" +
                        "Nous vous prions de retourner l'ouvrage dans les plus brefs délais afin de régulariser votre situation.");
                // Send Message!
                this.emailSender.send(message);
            }
        }





    }
}
