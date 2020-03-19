package org.nerdcore.flightcustomerservice;

import org.nerdcore.flightcustomerservice.entities.UserPrincipal;
import org.nerdcore.flightcustomerservice.repositories.UserPrincipalRepository;
import org.nerdcore.flightcustomerservice.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServices loginServices;

    @GetMapping("")
    public ModelAndView getLoginForm(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("/login");
    }

    @GetMapping("/show_users")
    public List<UserPrincipal> getAllUsers(){
          //loginServices.addOrUpdateUserPrincipal(new UserPrincipal("emily", "ahugenerd"));
//        loginServices.addOrUpdateUserPrincipal(new UserPrincipal("vince", "wordpass"));
//        loginServices.addOrUpdateUserPrincipal(new UserPrincipal("kazda", "drowssap"));
        return loginServices.getAllUsers();
    }





}
