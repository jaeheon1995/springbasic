package com.example.springbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
