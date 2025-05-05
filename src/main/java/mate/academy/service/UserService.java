package mate.academy.service;

import mate.academy.dao.UserRegistrationRequestDto;
import mate.academy.dao.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto request);
}
