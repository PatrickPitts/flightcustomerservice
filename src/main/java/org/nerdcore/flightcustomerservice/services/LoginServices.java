package org.nerdcore.flightcustomerservice.services;

import org.apache.catalina.User;
import org.nerdcore.flightcustomerservice.entities.UserPrincipal;
import org.nerdcore.flightcustomerservice.repositories.UserPrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginServices {


    @Autowired
    UserPrincipalRepository userPrincipalRepository;

    public boolean validLogin(UserPrincipal user){

        return user.getUsername().equals("username") && user.getPassword().equals("password");
    }

    public UserPrincipal addOrUpdateUserPrincipal(UserPrincipal userPrincipal){
        return userPrincipalRepository.saveAndFlush(userPrincipal);
    }

    public List<UserPrincipal> getAllUsers(){
        return userPrincipalRepository.findAll();
    }
}
