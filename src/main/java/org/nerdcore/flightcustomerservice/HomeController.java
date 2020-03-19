package org.nerdcore.flightcustomerservice;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class HomeController {

    private boolean hasAuthority(String auth){
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for(GrantedAuthority authority : authorityCollection){
            if (authority.getAuthority().equals(auth)){
                return true;
            }
        }
        return false;
    }

    private String getUsername(){
        return ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @RequestMapping("/")
    public ModelAndView getHomeView(){
        return new ModelAndView("home");
    }

    @RequestMapping("ticket")
    public ModelAndView getTickets(){
        System.out.println("ticket");
        ModelAndView mv = new ModelAndView("ticket/view-tickets");
        if(hasAuthority("READ_ALL_TICKETS")){
            mv.addObject("message", "Viewing All submitted Tickets");
        } else {
            mv.addObject("message", "Viewing Submitted tickets for " + getUsername());
        }

        return mv;
    }

    @RequestMapping("/ticket/submit")
    public ModelAndView getTicketSubmissionForm(){
        System.out.println("ticket/submit");
        ModelAndView mv = new ModelAndView("ticket/create-ticket");

        return mv;
    }

    @RequestMapping("/flight/add")
    public ModelAndView getCreateNewFlightForm(){
        System.out.println("flight/add");
        ModelAndView mv = new ModelAndView("flight/add-flight");

        return mv;
    }

    @RequestMapping("/flight")
    public ModelAndView getFlightSearchForm(){
        System.out.println("flight");
        ModelAndView mv = new ModelAndView("flight/search-flights");

        ArrayList<String> flights = new ArrayList<>();

        flights.add("flight1");
        flights.add("flight2");
        flights.add("flight3");
        mv.addObject("flights",flights);

        return mv;
    }

    @RequestMapping("/flight/{flightID}")
    public ModelAndView getSingleFlightView(@PathVariable("flightID")Long flightID){
        System.out.println("flight/id");
        ModelAndView mv = new ModelAndView("flight/single-flight");
        mv.addObject("flightID", flightID);

        return mv;
    }



}
