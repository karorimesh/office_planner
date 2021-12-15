package com.tracom.office_planner;

import com.tracom.office_planner.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    @Autowired
    private UserRepository userRepo;
    @GetMapping("")
    public String landPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "landing";
        }
        return "redirect:/home";
    }


    @GetMapping("/landing")
    public String landingPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "landing";
        }
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String viewHomePage()
    {
        return "homepage";
    }


    @GetMapping("/login")
    public String validateUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/home";
    }


    @GetMapping("/403")
    public String returnError(){
        return "403";
    }


}
