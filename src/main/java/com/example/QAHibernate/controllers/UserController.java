package com.example.QAHibernate.controllers;
import java.util.ArrayList;
import java.util.List;

import com.example.QAHibernate.entities.Answer;
import com.example.QAHibernate.entities.Question;
import com.example.QAHibernate.entities.User;
import com.example.QAHibernate.repositories.AnswerRepository;
import com.example.QAHibernate.repositories.QuestionRepository;
import com.example.QAHibernate.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * AnswerController
 */
@RestController
@RequestMapping(path="/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping(value="/users", produces="application/json")
    public List<User> displayUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value="/users", produces="application/json")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(value ="/users/{id}")
    public void deleteUser(@RequestBody User user2, @PathVariable("id") long id){
        User user = userRepository.findById(id).orElse(new User());
        if(user.getId() !=0L){
            List<Answer> answer = answerRepository.findAllByUserId(user.getId());
            answerRepository.deleteAll(answer);
            List <Question> question = questionRepository.findByUserId(user.getId());
            questionRepository.deleteAll(question);
            userRepository.delete(user);
        }
        // return user2;
    }
}