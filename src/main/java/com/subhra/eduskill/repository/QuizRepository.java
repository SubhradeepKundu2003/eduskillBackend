package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Course;
import com.subhra.eduskill.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCourse(Course course);
}
