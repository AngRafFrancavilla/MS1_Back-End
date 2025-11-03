package com.movie.ms1.service;

import com.movie.ms1.dto.UserDTO;
import com.movie.ms1.entity.Role;
import com.movie.ms1.entity.User;
import com.movie.ms1.mapper.UserMapper;
import com.movie.ms1.repository.RoleRepository;
import com.movie.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User registerUser(UserDTO dto){
        if(userRepository.existsByEmail(dto.getEmail())){
            throw  new RuntimeException("Email già registrata");
        }

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Role roleUser = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Ruolo USER non trovato"));

        user.setRoles(Set.of(roleUser));
        return userRepository.save(user);
    }

    public User createAdmin(UserDTO dto) {

        User user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
