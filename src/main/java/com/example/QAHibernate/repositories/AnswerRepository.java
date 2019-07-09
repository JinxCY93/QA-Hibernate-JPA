package com.example.QAHibernate.repositories;

import com.example.QAHibernate.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
/**
 * AnswerRepository
 */
public interface AnswerRepository extends JpaRepository<Answer, Long>{
    List<Answer> findAllByUserId(long userId);
    List<Answer> findAllByQuestionId(long questionId);
}