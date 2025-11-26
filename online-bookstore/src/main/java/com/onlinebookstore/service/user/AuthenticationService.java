package com.onlinebookstore.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
//    private final JwtUtil jwtUtil;
//    private final AuthenticationManager authenticationManager;
//
//    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
//        );
//        String token = jwtUtil.generateToken(authentication.getName());
//        return new UserLoginResponseDto(token);
//    }
}
