package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.RoleRepository;
import com.ocp7bibliotheque.bibliothequeadministration.DAO.UserAccountRepository;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.Role;
import com.ocp7bibliotheque.bibliothequeadministration.Entites.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Iterator;
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
        Collection<Role> roles = new Collection<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Role> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Role role) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Role> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        roles.add(defaultRole.get());
        roles.add(employeeRole.get());
        roles.add(adminRole.get());
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(roles);
        return userAccountRepository.save(account);
    }

    @Override
    public boolean isValid(UserAccount account) throws Exception {
        String password= bCryptPasswordEncoder.encode(account.getPassword());
        System.out.println("mot de passe : " +account.getPassword());
        System.out.println("mot de passe crypté : " +password);

        Optional<UserAccount> newUserAccount = userAccountRepository.findByMail(account.getMail());
        String passwordDB=newUserAccount.get().getPassword();
        System.out.println("mot de passe DB : " +passwordDB);
        if(newUserAccount.isEmpty()) {
            throw new Exception("Utilisateur inexistant!");
        }
        if (!password.equals(passwordDB)){
            throw new Exception("Login ou mot de passe incorrect !");
        }
        return newUserAccount.get().getActive();
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

    @Override
    public Page<UserAccount> searchUserAccount(String mail, String lastName, String firstName, int pages, int size) throws Exception {
        return userAccountRepository.searchUserAccount(mail, lastName,firstName, PageRequest.of(pages,size));
    }
}
