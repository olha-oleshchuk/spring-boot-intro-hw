package mate.academy.service;

import mate.academy.dao.user.UserLoginRequestDto;
import mate.academy.dao.user.UserLoginResponseDto;

public interface AuthService {
    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
