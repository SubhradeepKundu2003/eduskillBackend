package com.subhra.eduskill.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quiz that contains this question
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(name = "question_type", length = 50, nullable = false)
    private String questionType = "MCQ";  // e.g. MCQ, TRUE_FALSE, etc.

    @Column(nullable = false)
    private Integer marks = 1;

    @Column(name = "order_index")
    private Integer orderIndex;

    public Question() {
    }

    public Question(Long id, Quiz quiz, String text, String questionType, Integer marks, Integer orderIndex) {
        this.id = id;
        this.quiz = quiz;
        this.text = text;
        this.questionType = questionType;
        this.marks = marks;
        this.orderIndex = orderIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}
