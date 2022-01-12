package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.RoleRepository;
import com.ocp7bibliotheque.bibliothequeadministration.DAO.UserAccountRepository;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Role;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserAccountServiceImpl implements IUserAccountService{

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserAccount register(UserAccount account) throws Exception {
        Optional<Role> defaultRole = roleRepository.findByName("USER");
        if(defaultRole.isEmpty()) throw new Exception("Erreur lors de l'affectation du Role USER");
        Optional<Role> employeeRole = roleRepository.findByName("EMPLOYEE");
        if(employeeRole.isEmpty()) throw new Exception("Erreur lors de l'affectation du Role EMPLOYEE");
        Optional<Role> adminRole = roleRepository.findByName("ADMIN");
        if(adminRole.isEmpty()) throw new Exception("Erreur lors de l'affectation du Role ADMIN");
        Optional<UserAccount> newUser = userAccountRepository.findByMail(account.getMail());
        if(!newUser.isEmpty()) throw new Exception("Un utilisateur avec cette adresse mail existe déjà !");
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(defaultRole.get());
        roles.add(employeeRole.get());
        roles.add(adminRole.get());
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(roles);
        return userAccountRepository.save(account);
    }

    @Override
    public boolean isValid(UserAccount account) throws Exception {
        Optional<UserAccount> newUserAccount = userAccountRepository.findByMailAndPassword(account.getMail(),
                bCryptPasswordEncoder.encode(account.getPassword()));
        if(newUserAccount.isEmpty()) {
            throw new Exception("Login ou mot de passe incorrect!");
        }
        return newUserAccount.get().getActive();
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserAccount getUserAccount(String mail) throws Exception {
        Optional<UserAccount>connectedUser = userAccountRepository.findByMail(mail);
        if(connectedUser.isEmpty()) throw new Exception("Cette adresse mail n'a pas été trouvée !");
        return connectedUser.get();
    }

    @Override
    public void removeUserAccount(int idUserAccount) throws Exception {
        Optional<UserAccount> account = userAccountRepository.findById(idUserAccount);
        if(account.isEmpty()) throw new Exception("Le compte utilisateur n'existe pas !");
        userAccountRepository.delete(account.get());
    }
}
