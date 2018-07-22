package com.solopov.hillel.uquiz.controllers;

import com.solopov.hillel.uquiz.model.Quiz;
import com.solopov.hillel.uquiz.model.User;
import com.solopov.hillel.uquiz.service.QuizService;
import com.solopov.hillel.uquiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class QuizController {
    @Autowired
    QuizService quizService;
    @Autowired
    UserService userService;


    @RequestMapping(method = GET, value = "/quizlist")
    public String quizList(ModelMap model){
        model.addAttribute("list", quizService.getAllQuizzes());
        model.addAttribute("quizToAdd", new Quiz());
        return "QuizList";
    }

    @RequestMapping(method = POST, value ="/quizlist" )
    public String addQuiz(Model model, Principal principal, @ModelAttribute("quizToAdd") @Valid Quiz quiz,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("list", quizService.getAllQuizzes());
            return "QuizList"; //
        }
        User user= userService.getByLogin(principal.getName());
        user.getQuizzes().add(quiz);
        userService.update(user);
        return "redirect:/quizlist";
    }

    @RequestMapping(method = DELETE, value ="quizlist/{id}" )
    public @ResponseBody
    String deleteQuiz(@PathVariable("id") int id){
        quizService.deleteByID(id);
        return "OK";
    }
}
