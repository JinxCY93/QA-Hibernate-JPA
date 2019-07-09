package com.example.QAHibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionType;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Answer
 */
@DynamicUpdate
@Entity (name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="text")
    private String text;

    @Column (name="userId", updatable = false)
    private long userId;

    @Column (name="questionId" , updatable = false)
    private long questionId;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }  
}