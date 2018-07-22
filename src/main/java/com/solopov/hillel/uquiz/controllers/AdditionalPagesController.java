package com.solopov.hillel.uquiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AdditionalPagesController {
    private static Logger log = Logger.getLogger(AdminController.class.getName());
    @RequestMapping(method = GET, value = "/welcomepage")
    String welcomepage(){
        return "welcomepage";
    }

}
