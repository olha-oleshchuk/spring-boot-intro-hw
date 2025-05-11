package mate.academy.service;

import mate.academy.dao.UserLoginRequestDto;

public interface AuthService {
    String authenticate(UserLoginRequestDto requestDto);
}
