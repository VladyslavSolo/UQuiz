package com.solopov.hillel.uquiz.controllers;

import com.solopov.hillel.uquiz.model.User;
import com.solopov.hillel.uquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(method = GET, value = "/auth")
    public String authorization() {
        return "Authorization";
    }

    @RequestMapping(method = POST, value = "/auth")
    public String authorization(@RequestParam("login") String login,
                                    @RequestParam("password") String password,
                                    HttpSession session) {
        if (userService.isRegistered(login,password)) {
            User user= userService.getByLogin(login);
            session.setAttribute("login", user.getLogin());
            return "redirect:/quizlist";
        }
        return "Authorization";
    }

    @RequestMapping(method = GET, value = "/reg")
    public ModelAndView registration() {
        return new ModelAndView("Registration","userReg",new User());
    }

    @RequestMapping(method = POST, value = "/reg")
    public String registration(@ModelAttribute("userReg") @Valid User user, BindingResult bindingResult,
                               HttpSession session) {
        if(bindingResult.hasErrors()) return "Registration";
        if (userService.getByLogin(user.getLogin()) == null) {
            userService.addAccount(user);
            session.setAttribute("login", user.getLogin());
            return "welcomepage";
        }
        return "Registration";
    }

    @RequestMapping(method = GET, value = "logout")
    public String logout(HttpSession session) {
        session.setAttribute("login", null);
        session.removeAttribute("login");
        return "Authorization";
    }

}