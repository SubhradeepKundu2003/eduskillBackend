package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Course;
import com.subhra.eduskill.entity.User;
import com.subhra.eduskill.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCreatedBy(User createdBy); // teacher courses
}

