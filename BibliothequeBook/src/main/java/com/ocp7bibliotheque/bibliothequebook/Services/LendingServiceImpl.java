package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.DAO.BookRepository;
import com.ocp7bibliotheque.bibliothequebook.DAO.LendingRepository;
import com.ocp7bibliotheque.bibliothequebook.DAO.UserAccountRepository;
import com.ocp7bibliotheque.bibliothequebook.Entites.Book;
import com.ocp7bibliotheque.bibliothequebook.Entites.Lending;
import com.ocp7bibliotheque.bibliothequebook.Entites.Role;
import com.ocp7bibliotheque.bibliothequebook.Entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LendingServiceImpl implements ILendingService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    LendingRepository lendingRepository;

    @Override
    public Lending borrow(String userAccountMail, int idBook) throws Exception {
        Optional<Book> book = bookRepository.findById(idBook);
        if(book.isEmpty()) throw new Exception ("Ce livre n'existe pas !");
        Optional<UserAccount> userAccount = userAccountRepository.findByMail(userAccountMail);
        if(userAccount.isEmpty()) throw new Exception ("Cet utilisateur n'existe pas !");
        Lending lending = new Lending(userAccount.get(),book.get());
        book.get().setNumberExemplar(book.get().getNumberExemplar()-1);
        if (book.get().getNumberExemplar()==0) book.get().setAvailable(false);
        bookRepository.saveAndFlush(book.get());
        return lendingRepository.save(lending);
    }

    @Override
    public Lending extendLoan(int idLending) throws Exception {
        Optional<Lending> lending = lendingRepository.findById(idLending);
        if(lending.isEmpty()) throw new Exception ("Ce prêt n'existe pas !'");
        lending.get().setEndDate(lending.get().getEndDate().plusDays(28));
        lending.get().setExtensible(false);
        lending.get().setStatus("Prolongé");
        return lendingRepository.saveAndFlush(lending.get());
    }

    @Override
    public List<Lending> displayLoan(String mail) throws Exception {
        Optional<UserAccount> userAccount = userAccountRepository.findByMail(mail);
        if (userAccount.isEmpty()) throw new Exception ("Cet utilisateur n'existe pas !");
        for (Role role:userAccount.get().getRoles()
             ) {
            if (role.getName().equals("ADMIN") || role.getName().equals("EMPLOYEE")) return lendingRepository.findAll();
        }
        return lendingRepository.findByUserAccount(userAccount.get());
    }

    @Override
    public void returnLoan(int idLending) throws Exception {
        Optional<Lending> lending = lendingRepository.findById(idLending);
        if(lending.isEmpty()) throw new Exception ("Ce prêt n'existe pas !'");
        Optional<Book> book = bookRepository.findById(lending.get().getBook().getId());
        if(book.isEmpty()) throw new Exception ("Ce livre n'existe pas !");
        book.get().setNumberExemplar(book.get().getNumberExemplar()+1);
        bookRepository.saveAndFlush(book.get());
        lending.get().setStatus("Terminé");
        lendingRepository.saveAndFlush(lending.get());
    }
}
