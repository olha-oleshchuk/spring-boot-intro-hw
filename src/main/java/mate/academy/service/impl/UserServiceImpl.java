package mate.academy.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.dao.UserRegistrationRequestDto;
import mate.academy.dao.UserResponseDto;
import mate.academy.exception.RegistrationException;
import mate.academy.mapper.UserMapper;
import mate.academy.model.User;
import mate.academy.repository.UserRepository;
import mate.academy.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto request)
            throws RegistrationException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RegistrationException("Can't register user with email " + request.getEmail());
        }
        User user = userMapper.toModel(request);
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
