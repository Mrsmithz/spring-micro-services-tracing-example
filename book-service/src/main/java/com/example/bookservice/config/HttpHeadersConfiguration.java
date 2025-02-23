package com.example.bookservice.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.Objects;

@Configuration
public class HttpHeadersConfiguration {

    @Bean
    @Primary
    @RequestScope
    public HttpHeaders requestScopeHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            headers.set(headerNames.nextElement(), request.getHeader(headerNames.nextElement()));
        }

        return headers;
    }
}
