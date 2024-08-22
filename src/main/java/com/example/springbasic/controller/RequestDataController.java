package com.example.springbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbasic.DTO.validation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
// http://localhost:4000/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
    
//get http://localhost:4000/request-data/request-param
// request body가 존재하지 않고 url로 데이터를 전송하는
// query String 방식으로 데이터를 가져오기 위해 사용하는 어노테이션
    @GetMapping("/request-param")
    //get http://localhost:4000/request-data/request-param?name=홍길동&age=30
    public String requestParam(
        // @RequestParam(name="name") String name,
        @RequestParam("name") String name,
        @RequestParam(name="age", required=false) Integer age
    ){
        return "이름 : "+name+" 나이 :"+age;
    }

    // @PathVariable():
    // 모든 HTTP 메서드에서 URL 특정 패턴에 따라 데이터를 추출
    // Get http://localhost:4000/request-data/path-variable/$$$$/**
    @GetMapping({
        "/path-variable/{var}/{str}",
        "/path-variable/{var}/",
        "/path-variable/{var}"
    })
    public String pathVariable(
        @PathVariable(name="var") String var,
        @PathVariable(name="str", required=false) String str
    ){

        return "읽은 경로 변수 : "+var +","+str;
    }

// ! 주의
// 경로 변수를 사용하여 url 패턴을 작성할 때
// 겹치는 패턴이 있는지 잘 확인 해야함
    @GetMapping("/path-variable/other")
            public String OtherPathVariavle(){
            return "other메서드 호출";
        }

    @GetMapping("/path-variable/{var}/another")
    public String anotherPathVariable1(
        @PathVariable("var")String var
    ){
        return "another1";
    }

    @GetMapping("/path-variable/another/{var}")
    public String anotherPathVariable2(
        @PathVariable("var")String var
    ){
        return "another2";
    }

    //@RequestBody:
    // post,put,patch 처럼 Request body로 데이터를 전송하는 메서드에서 데이터를 읽기 위한 방법

    @PostMapping("/request-body")
    public String requestBody(
        // @RequestBody String requestBody
        @RequestBody SampleDto requestBody
    ) {

        return "Request Body data : " + requestBody.getName() + ", " + requestBody.getAge();
    }
    @PostMapping("/validation")
    public String validation(
        @RequestBody @Valid validation requestBody
    ) {
        return "정상";
    };
}

// DTO(Data Transfer Object)
// 데이터를 서로다른 계층간에 전송하기 위한 객체
// 캡슐화가 되어있음, 비즈니스 로직을 포함하지 않는다 private필드와 생성자,getter,setter만 존재

@Getter
@Setter
// @NoArgsConstructor
@AllArgsConstructor
class SampleDto{

    private String name;
    private int age;

}

