package com.solopov.hillel.uquiz.controllers;

import com.solopov.hillel.uquiz.dto.Notification;
import com.solopov.hillel.uquiz.model.User;
import com.solopov.hillel.uquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("admin")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(method = GET, value = "acclist")
    public String fillQuestionList(Model model) {
        model.addAttribute("list", userService.getAllUsers());
        model.addAttribute("roles", User.Role.values());
        return "accountlist";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','SUPERADMIN')")
    @ResponseBody
    @RequestMapping(method = POST,value = "changerole")
    public Notification changeRole(@RequestParam("role") String role, @RequestParam("id") Integer id){

        User user = userService.getByID(Integer.valueOf(id));
        user.setRole(role);
        userService.update(user);

        String notificationMessage = "Role " + role + " of user by id " + id + " " + user.getLogin() + "  was successfully installed!";
        return new Notification(notificationMessage,true);
    }
}