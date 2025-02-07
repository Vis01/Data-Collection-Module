package com.cdac.Acts.config;

<<<<<<< HEAD

=======
 
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< HEAD

=======
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
import com.cdac.Acts.entities.Role;
import com.cdac.Acts.entities.User;
import com.cdac.Acts.repository.UserRepository;

@Configuration
public class InitialAdminSetup {
<<<<<<< HEAD

=======
    // This class is used to create an initial admin user if no users exist in the database
>>>>>>> 6c116af2847faee897a2dfaf71c19c1e9e050611
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository) {
        return args -> {
            // Check if any users exist in the database
            if (userRepository.count() == 0) {
                // Create and save an initial admin user
                User admin = new User();
                admin.setUsername("admin"); // Set a default username
                admin.setPassword(passwordEncoder.encode("admin123")); // Set a default password
                admin.setRole(Role.ADMIN); // Set role to ADMIN
                userRepository.save(admin);
                System.out.println("Initial admin user created with username 'admin' and password 'admin123'");
            }
        };
    }
}
