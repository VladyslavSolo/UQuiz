package com.solopov.hillel.uquiz.controllers;


import com.solopov.hillel.uquiz.dao.AnswerDAO;
import com.solopov.hillel.uquiz.model.Answer;
import com.solopov.hillel.uquiz.model.Question;
import com.solopov.hillel.uquiz.model.Quiz;
import com.solopov.hillel.uquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuestionController {

    @Autowired
    QuizService quizService;

    @Autowired
    AnswerDAO answerDAO;

    @RequestMapping(method = GET, value = "quiz/{id}")
    public String fillQuestionList(Model model, @PathVariable("id") Integer id){
        model.addAttribute("list", quizService.getByID(id).getQuestions());
        return "QuestionList";
    }

    @RequestMapping(method = GET,value="quiz/{id}/newquestion")
    public String newQuestion(){
        return "Question";
    }

    @RequestMapping(method=POST, value="quiz/{id}/newquestion")
    public String addQuestion(Model model, @PathVariable("id") Integer quizID,
                              @RequestParam("titileOfQuestion") String titleOfQuestion,
                              @RequestParam("answers") String answerLine,
                              @RequestParam("rightanswers") String rightAnswers){
        StringTokenizer tokzer=new StringTokenizer(answerLine, "\n");

        List<Answer> answerList=new ArrayList<>();
        while (tokzer.hasMoreTokens()) {
            answerList.add(new Answer(tokzer.nextToken().trim()));
        }
        tokzer=new StringTokenizer(rightAnswers, "\n");
        for (int i=0;tokzer.hasMoreTokens();i++) {
            answerList.get(i).setRight(Boolean.parseBoolean(tokzer.nextToken().trim()));
        }
        Question qu=new Question(titleOfQuestion,answerList);
        Quiz currentQuiz=quizService.getByID(quizID);
        currentQuiz.getQuestions().add(qu);
        quizService.update(currentQuiz);

        return "redirect:/quiz/{id}";
    }

    @RequestMapping(method = GET, value ="quiz/{idquiz}/removequestion/{idquesion}")
    public String removeQuestion(@PathVariable("idquesion") int id){
        quizService.deleteByID(id);
        return "redirect:quiz/{idquiz}/";
    }

}
