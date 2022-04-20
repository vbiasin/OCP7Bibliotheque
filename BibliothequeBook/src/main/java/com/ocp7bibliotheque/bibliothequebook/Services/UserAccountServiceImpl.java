package com.ocp7bibliotheque.bibliothequebook.Services;

import com.ocp7bibliotheque.bibliothequebook.DAO.UserAccountRepository;
import com.ocp7bibliotheque.bibliothequebook.Entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserAccountServiceImpl implements IUserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public Boolean checkUserAccountContact(String mail) throws Exception {
        Optional<UserAccount> userAccount = userAccountRepository.findByMail(mail);
        if(userAccount.isEmpty()) throw new Exception ("Cet utilisateur n'existe pas !");
        if(userAccount.get().getContact()==null) return false;
        return true;
    }
}
