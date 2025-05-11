package mate.academy.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.UserLoginRequestDto;
import mate.academy.model.User;
import mate.academy.repository.UserRepository;
import mate.academy.util.HashUtil;
import mate.academy.util.TokenUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final UserRepository userRepository;
    private final TokenUtil tokenUtil;
    private final HashUtil hashUtil;

    public String authenticate(UserLoginRequestDto requestDto) {
        Optional<User> user = userRepository.findByEmail(requestDto.getEmail());
        if (user.isEmpty()) {
            throw new RuntimeException("Can't login");
        }
        String userPasswordFromDb = user.get().getPassword();
        String hashedPassword = HashUtil.hashPassword(requestDto.getPassword(), hashUtil.getSalt());
        if (!hashedPassword.equals(userPasswordFromDb)) {
            throw new RuntimeException("Can't login");
        }
        return tokenUtil.generateToken(requestDto.getEmail());
    }
}
