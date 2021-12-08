package com.ocp7bibliotheque.bibliothequeadministration.Services;

import com.ocp7bibliotheque.bibliothequeadministration.DAO.RoleRepository;
import com.ocp7bibliotheque.bibliothequeadministration.DAO.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements IRoleService{

    @Autowired
    UserAccountRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void addRoleToUserAccount(String mail, int idRole) throws Exception {

    }

    @Override
    public void removeRoleFromUserAccount(String mail, int idRole) throws Exception {

    }
}
