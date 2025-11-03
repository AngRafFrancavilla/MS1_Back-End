package com.movie.ms1.controller;

import com.movie.ms1.dto.UserDTO;
import com.movie.ms1.entity.User;
import com.movie.ms1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO dto){
        return ResponseEntity.ok(userService.registerUser(dto));
    }

    @PostMapping("/admin/create")
    public ResponseEntity<User> createAdmin(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.createAdmin(dto));
    }
}
