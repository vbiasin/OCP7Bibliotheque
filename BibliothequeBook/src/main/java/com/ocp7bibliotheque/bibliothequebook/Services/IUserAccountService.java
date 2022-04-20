package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.Entites.UserAccount;

public interface IUserAccountService {
    public Boolean checkUserAccountContact(String mail) throws Exception;
}
