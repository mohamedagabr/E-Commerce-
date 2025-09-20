package com.gabr.e_commerce.service;

import com.gabr.e_commerce.mapper.UserMapper;
import com.gabr.e_commerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserMapper userMapper;
    UserRepository userRepository;
}
