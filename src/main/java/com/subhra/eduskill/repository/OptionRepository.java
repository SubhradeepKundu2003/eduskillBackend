package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Option;
import com.subhra.eduskill.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestion(Question question);
}