package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Quiz;
import com.subhra.eduskill.entity.QuizAttempt;
import com.subhra.eduskill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByStudent(User student);
    List<QuizAttempt> findByQuiz(Quiz quiz);
}
