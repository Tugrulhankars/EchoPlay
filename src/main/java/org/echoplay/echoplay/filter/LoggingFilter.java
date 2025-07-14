package org.echoplay.echoplay.filter;

import com.sun.net.httpserver.HttpExchange;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.echoplay.echoplay.filter.wrapper.RequestWrapper;
import org.echoplay.echoplay.filter.wrapper.ResponseWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpServletRequest requestToUse = request;

        if (request.getContentType() != null && !request.getContentType().startsWith("multipart/")) {
            requestToUse = new RequestWrapper(request); // JSON veya x-www-form-urlencoded için
        }

        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        filterChain.doFilter(requestToUse, responseWrapper);

        // Response Body Loglama
        byte[] copy = responseWrapper.getCopyBody();
        String responseBody = new String(copy, response.getCharacterEncoding());
        System.out.println("Response Body: " + responseBody);

        // Response tekrar yazdır
        response.getOutputStream().write(copy);
    }
}
