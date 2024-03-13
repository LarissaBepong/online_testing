package dev.berela.online_testing_backend.service.impl;

import dev.berela.online_testing_backend.auth.JwtUtil;
import dev.berela.online_testing_backend.bean.AuthenticationRequestBean;
import dev.berela.online_testing_backend.bean.AuthenticationResponseBean;
import dev.berela.online_testing_backend.repository.UserRepository;
import dev.berela.online_testing_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

//    @Override
//    public AuthenticationResponseBean register(RegisterRequestBean request) {
//        var user = User.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
//        userRepository.save(user);
//        var jwtToken = jwtUtil.generateToken(user);
//        return AuthenticationResponseBean.builder()
//                .accessToken(jwtToken)
//                .build();
//    }

    @Override
    public AuthenticationResponseBean authenticate(AuthenticationRequestBean request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponseBean.builder()
                .accessToken(jwtToken)
                .build();
    }
}
