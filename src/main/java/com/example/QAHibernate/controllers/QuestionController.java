package com.example.QAHibernate.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * QuestionController
 */

@RestController
@RequestMapping(path ="/api")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @PostMapping(value="/questions")
    public void addQuestions(@RequestBody Question question){        
        questionRepository.save(question);
    }

    // problem
    @GetMapping(value="/questions", produces ="application/json")
    public List<Question> displayQuestionsByDesc(@RequestParam (required=false) String description){
        if(description!=null){
            return questionRepository.findByDescriptionLike(description);
        }
        return questionRepository.findAll();
    }
}

