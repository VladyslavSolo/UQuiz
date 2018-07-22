package com.solopov.hillel.uquiz.service;

import com.solopov.hillel.uquiz.dao.QuestionDAO;
import com.solopov.hillel.uquiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public boolean removeQuestion(Set<Question> quSet, int id){
        Question question = null;
        for (Question qu:quSet)
            if(qu.getId()==id){
                question=qu;
                break;
            }
        return quSet.remove(question);
    }
}