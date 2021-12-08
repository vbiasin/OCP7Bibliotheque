package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;

public interface IUserAccountService {

    public UserAccount register(UserAccount account) throws Exception;
    public boolean isValid(UserAccount account) throws Exception;
    public UserAccount getUserAccount(String mail) throws Exception;
    public void removeUserAccount(int idUserAccount) throws Exception;

}
