package com.example.springbasic.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// client request body 데이터의 유효성검사
// spring-boot-starter-validation 라이브러리 사용
//스프링 프레임워크에서 제공하는 유효성검사 인터페이스 라이브러리
//클라이언트가 서버측에 데이터를 전송할 때 유효성 검사라하고 정확한 데이터만 받을수 있도록 도움
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class validation {

    //@Notnull:null값을 허용하지 않음 
    @NotNull
    
    private String notnull;
}
