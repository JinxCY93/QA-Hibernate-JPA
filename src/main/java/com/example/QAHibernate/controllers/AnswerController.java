package com.example.QAHibernate.controllers;

import com.example.QAHibernate.entities.Answer;
import com.example.QAHibernate.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnswerController
 */

 @RestController
 @RequestMapping (path ="/api")
public class AnswerController {
    @Autowired
    AnswerRepository answerRepository;

    @PostMapping(value = "/answers/{id}")
    public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") long id){
        Answer existingAnswer = answerRepository.findById(id).orElse(new Answer());
        if(existingAnswer.getId() != null){
            answer.setId(id);
            answerRepository.save(answer);
        }
    }
}
