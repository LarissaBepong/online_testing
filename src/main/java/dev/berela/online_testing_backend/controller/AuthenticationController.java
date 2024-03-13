package dev.berela.online_testing_backend.controller;

import dev.berela.online_testing_backend.bean.AuthenticationRequestBean;
import dev.berela.online_testing_backend.bean.AuthenticationResponseBean;
import dev.berela.online_testing_backend.bean.UserSaveBean;
import dev.berela.online_testing_backend.controller.api.AuthenticationApi;
import dev.berela.online_testing_backend.service.AuthenticationService;
import dev.berela.online_testing_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {
    private final AuthenticationService authenticationService;
    private final UserService userService;
//    @Override
//    public ResponseEntity<AuthenticationResponseBean> register(RegisterRequestBean request) {
//        return ResponseEntity.ok(authenticationService.register(request));
//    }

    @Override
    public ResponseEntity<AuthenticationResponseBean> authenticate(AuthenticationRequestBean request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @Override
    public void saveUser(UserSaveBean bean) {
        userService.saveUser(bean);
    }

    @Override
    public void updateUser(UserSaveBean bean) {
        userService.updateUser(bean);
    }
}
