package org.echoplay.echoplay.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
/*
* AuthenticationEntryPoint, kullanıcının kimliği doğrulanmadığında (örneğin JWT token yoksa veya geçersizse), Spring Security'nin nasıl bir yanıt vereceğini tanımlar.
 * */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"authenticated\": false, \"message\": \"User is not authenticated\"}");
    }
}
