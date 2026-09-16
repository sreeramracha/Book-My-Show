package com.scaleracademy.BookMyShow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaleracademy.BookMyShow.controller.UserController;
import com.scaleracademy.BookMyShow.dto.SignUpRequestDto;
import com.scaleracademy.BookMyShow.dto.SignUpResponseDto;
import com.scaleracademy.BookMyShow.service.UserService;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner{
	
	@Autowired 
	private UserController userController;

	@Autowired 
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto request=new SignUpRequestDto();
		request.setEmail("abc@gmail.com");
		request.setName("Virat");
		request.setMobileNumber("123456789");
		request.setPassword("virat123");

		SignUpResponseDto response=userController.signUp(request);
		System.out.println(response.getStatus());
		System.out.println(response.getUserId());

		System.out.println(userService.login("abc@gmail.com", "virat12345"));
	}

}
