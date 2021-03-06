package ru.picnic.picnicservice.controller;

import static java.util.Objects.nonNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("home")
    public ModelAndView getHomePageWithWelcome(Principal principal) {
        ModelAndView homePage = new ModelAndView();

        String name = (nonNull(principal)) ? principal.getName() : "guest";
        homePage.addObject("userName", name);

        return homePage;
    }
}
