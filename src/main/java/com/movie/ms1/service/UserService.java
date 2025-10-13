package com.movie.ms1.service;

import com.movie.ms1.entity.Role;
import com.movie.ms1.entity.User;
import com.movie.ms1.repository.RoleRepository;
import com.movie.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor //

public class UserService {

    private final UserRepository userRepository; //
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder; //

    public User registerUser(User user){
        if(userRepository.existsByEmail((user.getEmail()))){
            throw  new RuntimeException("Email già registrata");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); //
        user.setEnabled(true);//

        Role roleUser = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Ruolo USER non trovato"));

        user.setRoles(Set.of(roleUser));
        return userRepository.save(user);
    }

    public User createAdmin(User user) {
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        user.setEnabled(true);

        Role roleAdmin = roleRepository.findByName("ADMIN")
                .orElseThrow(() -> new RuntimeException("Ruolo ADMIN non trovato"));

        user.setRoles(Set.of(roleAdmin));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
