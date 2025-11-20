package com.subhra.eduskill.repository;

import com.subhra.eduskill.entity.Role;
import com.subhra.eduskill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByRole(Role role);

}
