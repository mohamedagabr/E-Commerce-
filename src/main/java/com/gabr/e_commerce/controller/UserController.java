package com.gabr.e_commerce.controller;

import com.gabr.e_commerce.dto.UserDto;
import com.gabr.e_commerce.response.ApiResponse;
import com.gabr.e_commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDto>> registerUser(@RequestBody UserDto userDto){
        UserDto user = userService.registerUser(userDto);
        return ResponseEntity.ok(new ApiResponse<>("User registered successfully",user.getUsername()));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> loginUser(@RequestBody UserDto userDto){
        String token = userService.loginUser(userDto);
        return ResponseEntity.ok(new ApiResponse<>("User logged in successfully",token));
    }

}
