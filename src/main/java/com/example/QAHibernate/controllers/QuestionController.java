package com.example.QAHibernate.controllers;

import com.example.QAHibernate.entities.Answer;
import com.example.QAHibernate.entities.Question;
import com.example.QAHibernate.repositories.QuestionRepository;
import com.example.QAHibernate.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * QuestionController
 */

@RestController
@RequestMapping(path ="/api")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;


    @PostMapping(value="/questions")
    public void addQuestions(@RequestBody Question question){        
        questionRepository.save(question);
    }

    @PostMapping(value="/questions/{id}/answers")
    public void createAnswer(@RequestBody Answer answer, @PathVariable("id") long id){
        answer.setQuestionId(id);
        answerRepository.save(answer);
    }
}

