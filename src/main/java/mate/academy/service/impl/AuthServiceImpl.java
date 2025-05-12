package mate.academy.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.dao.UserLoginRequestDto;
import mate.academy.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public String authenticate(UserLoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getEmail(),
                        requestDto.getPassword())
        );
        return jwtUtil.generateToken(authentication.getName());
    }
}
