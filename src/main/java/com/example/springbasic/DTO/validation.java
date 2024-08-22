package com.example.springbasic.DTO;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    // @Notnull:null값을 허용하지 않음
    @NotNull
    private String notNull;
    // @NotEmpty: 문자열 타입에서 null과 빈문자열 ("")을 허용하지 않는다
    @NotEmpty
    private String notEmpty;
    // @NotBlank 문자열 타입에서 null 빈문자열("") 공백문자열("   ")을 허용하지 않는다
    @NotBlank
    private String notBlank;
    // client로부터 데이터를 받을 때는 기본형데이터 타입을 쓰지 않는게 좋음
    @NotNull
    // @NotBlank->X 문자열만 검사할 수 있음
    private Integer number;

    // @Length(min=?,max=?) 문자열 타입에서 길이에 최소 최대를 지정
    // @null이면 검사하지 않는다
    @Length(min = 4)
    @NotNull
    private String length;

    // @Min,@Max: 정수의 최대 최솟값지정
    @Min(10)
    @Max(20)
    private Integer minMax;

    // @Range(min=?, max=?)
    @Range(min = 5, max = 25)
    private Integer range;
    // @Size(min=?, max=?) : 컬렉션의 길이 최소 최댓값
    @Size(min = 2, max = 4)
    private Integer[] size;

    // @pattern(regexp=정규식): 정규식을 이용하여 문자열의 패턴을 검사
    @Pattern(regexp = "^[a-zA-z]$")
    private String pattern;
}
