package com.example.bootcampcharity.config;

import com.example.bootcampcharity.models.dtoes.serviceCall.TokenValidityResponseDto;
import com.example.bootcampcharity.services.serviceCall.IdentityServiceFeignClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class HeaderValidationFilter extends OncePerRequestFilter {

    @Autowired
    IdentityServiceFeignClient client;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String tokenValue = request.getHeader("token");
        ResponseEntity<TokenValidityResponseDto> tokenValidityResponseDto = client.checkTokenValidity(tokenValue, "fa");

        if (tokenValidityResponseDto.getStatusCode().is4xxClientError() ||
                tokenValidityResponseDto.getStatusCode().is5xxServerError()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized access");
        }

        if (tokenValue != null && tokenValidityResponseDto.getBody().getUsername() != null) {
            // Header is valid, proceed to controller
            filterChain.doFilter(request, response);
        } else {
            // Header is invalid, return an error response
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized access");
        }
    }
}
