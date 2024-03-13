package dev.berela.online_testing_backend.service.impl;

import com.google.common.base.Strings;
import dev.berela.online_testing_backend.auth.JwtUtil;
import dev.berela.online_testing_backend.bean.UserSaveBean;
import dev.berela.online_testing_backend.entity.User;
import dev.berela.online_testing_backend.entity.enumeration.Role;
import dev.berela.online_testing_backend.repository.UserRepository;
import dev.berela.online_testing_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new BadCredentialsException("The user with the login " + email + " was not found in the system"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new BadCredentialsException("The user with the id " + id + " was not found in the system"));
    }

    @Override
    public void saveUser(UserSaveBean bean) {
        User user = User.builder()
                    .name(bean.getName())
                    .email(bean.getEmail())
                    .active(bean.isActive())
                    .password(passwordEncoder.encode(Strings.isNullOrEmpty(bean.getPassword()) ? "12345" : bean.getPassword()))
                    .role(Strings.isNullOrEmpty(bean.getRole().name()) ? Role.USER : bean.getRole())
                    .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserSaveBean bean) {
        User user = findById(bean.getId());
        user.setName(bean.getName());
        user.setEmail(bean.getEmail());
        user.setRole(Strings.isNullOrEmpty(bean.getRole().name()) ? Role.USER : bean.getRole());
        userRepository.save(user);
    }
}
