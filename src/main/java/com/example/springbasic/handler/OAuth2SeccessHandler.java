package com.example.springbasic.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.springbasic.service.object.CustomOAuth2User;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// - SimpleUrlAuthenticationSuccessHandler 클래스 확장
// - response 처리 담당
@Component
public class OAuth2SeccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    
    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        // Authentication 매개변수에 서비스의 loadUser 메서드의 반환 값이 담겨있음
        Authentication authentication
    ) throws IOException, ServletException, java.io.IOException {

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        response.sendRedirect("https://naver.com");

    }

}