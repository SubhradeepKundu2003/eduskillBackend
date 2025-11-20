package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Question;
import com.subhra.eduskill.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
