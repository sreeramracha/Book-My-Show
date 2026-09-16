package com.scaleracademy.BookMyShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scaleracademy.BookMyShow.dto.SignUpRequestDto;
import com.scaleracademy.BookMyShow.exception.EmailExistsException;
import com.scaleracademy.BookMyShow.exception.UserNotFoundException;
import com.scaleracademy.BookMyShow.model.User;
import com.scaleracademy.BookMyShow.repository.UserRepository;

@Service 
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }

    public User signUp(SignUpRequestDto requestDto) {
        Optional<User> userOptional=userRepository.findByEmail(requestDto.getEmail());
        if (userOptional.isPresent()){
            throw new EmailExistsException("email already exsits");
        }

        User user=new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setMobileNumber(requestDto.getMobileNumber());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        
        return userRepository.save(user);
    }

    public boolean login(String email, String password){
        User user=userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user not exists"));
        return passwordEncoder.matches(password, user.getPassword());
    }
    
}
