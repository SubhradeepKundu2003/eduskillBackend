package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.QuizAttempt;
import com.subhra.eduskill.entity.QuizAttemptAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptAnswerRepository extends JpaRepository<QuizAttemptAnswer, Long> {
    List<QuizAttemptAnswer> findByQuizAttempt(QuizAttempt quizAttempt);
}
