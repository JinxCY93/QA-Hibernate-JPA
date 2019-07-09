package com.example.QAHibernate.controllers;

import java.util.List;

import com.example.QAHibernate.entities.Answer;
import com.example.QAHibernate.entities.Question;
import com.example.QAHibernate.repositories.AnswerRepository;
import com.example.QAHibernate.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping(value = "/answers/{id}")
    public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") long id){
        Answer existingAnswer = answerRepository.findById(id).orElse(new Answer());
        if(existingAnswer.getId() != 0L){
            answer.setId(id);
            answerRepository.save(answer);
        }
    }

    @PostMapping(value="/questions/{questionId}/answers")
    public void createAnswer(@RequestBody Answer answer, @PathVariable("questionId") long questionId){
        Question question = questionRepository.findById(questionId).orElse(new Question());

        if(question.getId()!=0L){
            answer.setQuestionId(questionId);
            answerRepository.save(answer);   
        }
        // return answer;
    }

    @GetMapping(value ="/questions/{questionId}/answers", produces="application/json")
    public List<Answer> getAnswerByQuestId(@PathVariable long questionId){
        return answerRepository.findAllByQuestionId(questionId);
    }   
}