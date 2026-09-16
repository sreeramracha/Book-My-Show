package com.scaleracademy.BookMyShow.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter 
@Setter 
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequestDto {
    String email;
    String password;
    String name;
    String mobileNumber;
}
