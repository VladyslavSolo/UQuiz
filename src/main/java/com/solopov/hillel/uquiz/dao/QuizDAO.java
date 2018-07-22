package com.solopov.hillel.uquiz.dao;

import com.solopov.hillel.uquiz.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface QuizDAO extends CrudRepository<Quiz, Integer> {
}
