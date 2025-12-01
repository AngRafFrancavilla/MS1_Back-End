package com.movie.ms1.service;

import com.movie.ms1.dto.UserDTO;
import com.movie.ms1.entity.User;

import java.util.Optional;

public interface UserService {

    User registerUser(UserDTO dto);

    User createAdmin(UserDTO dto);

    Optional<User> findByUsername(String username);
}
