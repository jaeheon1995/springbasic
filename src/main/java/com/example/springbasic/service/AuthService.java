package com.example.springbasic.service;

import com.example.springbasic.DTO.PostUserRequestDto;
import com.example.springbasic.DTO.SignInRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);
    String signIn(SignInRequestDto dto);
}