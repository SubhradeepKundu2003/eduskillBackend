package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Course;
import com.subhra.eduskill.entity.Enrollment;
import com.subhra.eduskill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByStudentAndCourse(User student, Course course);
    List<Enrollment> findByStudent(User student);
    List<Enrollment> findByCourse(Course course);
}
