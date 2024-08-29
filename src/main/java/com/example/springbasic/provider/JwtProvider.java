package com.example.springbasic.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

    // JWT:
    // - Json Web Token,RFC7519번에 정의된 json형식의 문자열을 포함하는 토큰 
    // - 인증 및 인가
    // - 암호화가 되어 있어 클라이언트와 서버간의 안전한 데이터 전달을 수행할 수 있다.
    // - 헤더 : token의 유형, 암호화 알고리즘이 지정되어 있음
    // - 페이로드 : 클라이언트,서버가 전달할 데이터가 포함 
    //  서명 : 헤더와 페이로드를 합쳐서 인코딩하고 비밀키로 암호화한 데이터가 포함
@Component
public class JwtProvider {
    
    // jwt암호화에 사용되는 암호키는 보안 관리가 되어야 함
    // 코드에 직접 작성을 하면 보안상 좋지않다.

    // 해결책
    // -1.application.properties/application.yaml 에 등록
    // -application.properties/application.yaml에 비밀키 작성
    // -@value()를 이용 값을 가져옴
    // -주의사항: application.properties/application.yaml 을 .gitignore에 등록해야함
    @Value("${jwt.secret}")
    private String secretKey;
    

    // 2. 시스템의 환경변수로 등록하여 사용
    // - OS 자체의 시스템 환경변수에 비밀키를 등록
    // - Spring에서 환경 변수 값을 읽어서 사용

    // 3.외부데이터 관리도구 사용
    // - 자체서버가 아닌 타 서버에 등록된 vault도구를 사용하여 비밀키 관리
    //  - os부팅시에 vault서버에서 비밀키를 받아와서 사용
    // - os매 부팅시마다 새로운 비밀키를 부여
    public String create(String name){

        // JWT의 만료일자 및 시간 지정
        Date expiredDate = Date.from(Instant.now().plus(4,ChronoUnit.HOURS));
        
        //  비밀키 생성
        // String secretKey = "qwertyuiopasdfghjkl12345678912345678901234567890";
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        // JWt 생성
        String jwt = Jwts.builder()
            // 서명 (암호화시 사용할 비밀키와 알고리즘을 전달)
            .signWith(key,SignatureAlgorithm.HS256)
            // 페이로드
            // 작성자
            .setSubject(name)
            //생성시간(현재시간)
            .setIssuedAt(new Date())
            // 만료시간
            .setExpiration(expiredDate)
            // 인코드 (압축)
            .compact();

        return jwt;
    }

}
