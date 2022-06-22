package com.ocp7bibliotheque.bibliothequebatchmail.Service;

import com.ocp7bibliotheque.bibliothequebatchmail.DAO.LendingRepository;

import com.ocp7bibliotheque.bibliothequebatchmail.Entites.Lending;
import com.ocp7bibliotheque.bibliothequebatchmail.Mail.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableScheduling
@Service
@Transactional
public class MailAlert {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    LendingRepository lendingRepository;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        mailSender.setUsername(MyConstants.MY_EMAIL);
        mailSender.setPassword(MyConstants.MY_PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Scheduled(fixedRate = 86400000) // 24*60*60*1000
    public void mailDiffusor(){
        List<Lending> lendings = lendingRepository.findAll() ;
        for (Lending lending:lendings) {
            if(lending.getEndDate().isBefore(LocalDateTime.now())){
                // Create a Simple MailMessage.
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(lending.getUserAccount().getMail());
                message.setSubject("Prêt en retard");
                message.setText("Bonjour, votre prêt "+lending.getBook().getTitle()+" effectué le " +lending.getStartDate()+" à la librairie: "
                        +lending.getBook().getLibrary().getName() + " est arrivé à échéance. Si ce n'est pas déjà le cas vous pouvez le prolonger dans votre espace personnel. " +
                        "Nous vous prions de retourner l'ouvrage dans les plus brefs délais afin de régulariser votre situation.");
                // Send Message!
            this.emailSender.send(message);
            }
        }
    }
}
