package com.scaleracademy.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaleracademy.BookMyShow.dto.SignUpRequestDto;
import com.scaleracademy.BookMyShow.dto.SignUpResponseDto;
import com.scaleracademy.BookMyShow.model.User;
import com.scaleracademy.BookMyShow.model.enums.ResponseStatus;
import com.scaleracademy.BookMyShow.service.UserService;

@Controller 
public class UserController {
    private UserService userService;

    @Autowired 
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto requestDto){
        SignUpResponseDto responseDto=new SignUpResponseDto(0, null);

        try {
            User savedUser=userService.signUp(requestDto);
            responseDto.setUserId(savedUser.getId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }

    
}
