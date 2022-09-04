package com.maftei.licenta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class StaticControllers {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Locale locale, Model model) {
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String loginWithError(Locale locale, Model model) {
        model.addAttribute("error", true);
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/uncaughtException", method = RequestMethod.GET)
    public String uncaughtException() {
        return "uncaughtException";
    }

    @RequestMapping(value = "/resourceNotFound", method = RequestMethod.GET)
    public String resourceNotFound() {
        return "resourceNotFound";
    }

    @RequestMapping(value = "/dataAccessFailure", method = RequestMethod.GET)
    public String dataAccessFailure() {
        return "dataAccessFailure";
    }
}