package com.gabr.e_commerce.service;

import com.gabr.e_commerce.dto.LoginDto;
import com.gabr.e_commerce.dto.UserDto;
import com.gabr.e_commerce.mapper.UserMapper;
import com.gabr.e_commerce.model.User;
import com.gabr.e_commerce.repository.UserRepository;
import com.gabr.e_commerce.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserDto registerUser(UserDto userDto){
        User  user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
    public String loginUser(LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword())
        );
        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();
        return jwtUtil.generateToken(user);
    }


}
