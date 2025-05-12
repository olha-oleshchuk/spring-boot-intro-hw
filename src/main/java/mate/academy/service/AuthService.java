package mate.academy.service;

import mate.academy.dao.UserLoginRequestDto;
import mate.academy.dao.UserLoginResponseDto;

public interface AuthService {
    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
