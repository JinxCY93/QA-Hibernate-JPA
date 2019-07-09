package com.example.QAHibernate.response_formats;

import java.util.List;
import com.example.QAHibernate.entities.User;
import com.example.QAHibernate.entities.Question;
import com.example.QAHibernate.entities.Answer;
/**
 * QAUser
 */
public class QAJson {
    
    List<Question> question;
    List<Answer> answer;


    public List<Question> getQuestion() {
        return this.question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return this.answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
    
}
