package com.subhra.eduskill.config;


import com.subhra.eduskill.entity.Role;
import com.subhra.eduskill.entity.User;
import com.subhra.eduskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Bean
    public CommandLineRunner createDefaultAdmin() {
        return args -> {

            if (!userRepository.existsByRole(Role.ADMIN)) {

                User admin = new User();
                admin.setFullName("Default Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole(Role.ADMIN);

                userRepository.save(admin);

                System.out.println("🚀 Default Admin Created!");
                System.out.println("Email: " + adminEmail);
                System.out.println("Password: " + adminPassword);
            } else {
                System.out.println("✔ Admin already exists.");
            }
        };
    }
}

