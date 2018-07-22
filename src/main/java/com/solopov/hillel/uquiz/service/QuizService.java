package com.solopov.hillel.uquiz.service;

import com.solopov.hillel.uquiz.dao.QuizDAO;
import com.solopov.hillel.uquiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;

    public boolean update(Quiz quiz) {
        if (!quizDAO.existsById(quiz.getId())) return false;
        quizDAO.save(quiz);
        return true;
    }

    public void deleteByID(int id){
        quizDAO.deleteById(id);
    }
    public Quiz getByID(int id) {
        return quizDAO.findById(id).get();
    }

        public List<Quiz> getAllQuizzes(){
            return (List<Quiz>) quizDAO.findAll();
    }

    public boolean removeQuiz(Set<Quiz> quizSet, int id) {
        Quiz quiz = null;
        for (Quiz currQuiz : quizSet)
            if (currQuiz.getId() == id) {
                quiz = currQuiz;
                break;
            }
        return quizSet.remove(quiz);
    }
}
