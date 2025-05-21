package mate.academy.service;

import mate.academy.dao.user.UserRegistrationRequestDto;
import mate.academy.dao.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto request);
}
