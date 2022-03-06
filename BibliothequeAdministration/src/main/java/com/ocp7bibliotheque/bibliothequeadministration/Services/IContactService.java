package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.Contact;

public interface IContactService {

    public Contact addContact(int idUserAccount, Contact contact) throws Exception;
    public Contact modifyContact(int idContact, Contact newContact) throws Exception;

}
