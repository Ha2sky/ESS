package com.jb.ess.common.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String errorMessage = "로그인에 실패했습니다.";

        // 에러 메시지를 쿼리스트링으로 로그인 페이지로 전달
        response.sendRedirect("/login?error=true&message=" + URLEncoder.encode(errorMessage,
                                                                     StandardCharsets.UTF_8));
    }
}
