package com.solopov.hillel.uquiz.dao;

import com.solopov.hillel.uquiz.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface QuestionDAO extends CrudRepository<Question,Integer> {
}
