package com.example.QAHibernate.repositories;
import com.example.QAHibernate.entities.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * QuestionRepository
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByUserId(long userId);
    List<Question> findByDescriptionContaining(String description);

    // @Query("select q.description from question q where q.userId=?1")
    // List<Question> findAllByUserId(long userId);
}