package com.example.springbasic.service;

import org.springframework.http.ResponseEntity;

import com.example.springbasic.DTO.PostSample1Request;

public interface SampleService {
    ResponseEntity<String> postSample1(PostSample1Request dto);
}
