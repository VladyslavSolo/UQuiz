package com.solopov.hillel.uquiz.dao;

import com.solopov.hillel.uquiz.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AnswerDAO extends CrudRepository<Answer,Integer> {
}
