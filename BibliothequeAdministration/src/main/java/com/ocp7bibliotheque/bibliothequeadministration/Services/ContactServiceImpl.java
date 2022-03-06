package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.ContactRepository;
import com.ocp7bibliotheque.bibliothequeadministration.DAO.UserAccountRepository;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact addContact(int idUserAccount, Contact newContact) throws Exception {
        Optional<UserAccount> account = userAccountRepository.findById(idUserAccount);
        if (account.isEmpty()) throw new Exception("Compte inexistant !");
        if (account.get().getContact() != null) throw new Exception("Un contact est déjà associé à cet utilisateur !");
        account.get().setContact(newContact);
        contactRepository.save(newContact);
        userAccountRepository.saveAndFlush(account.get());
        return newContact;
    }

    @Override
    public Contact modifyContact(int idContact, Contact newContact) throws Exception {
        Optional<Contact> contact = contactRepository.findById(idContact);
        if (contact.isEmpty()) throw new Exception("Le contact n'existe pas !");
        contact.get().setAddress(newContact.getAddress());
        contact.get().setLastName(newContact.getLastName());
        //contact.get().setFirstName(newContact.getFirstName());
        return contactRepository.saveAndFlush(contact.get());
    }

}

