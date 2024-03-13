package dev.berela.online_testing_backend.controller;

import dev.berela.online_testing_backend.bean.UserSaveBean;
import dev.berela.online_testing_backend.controller.api.UserApi;
import dev.berela.online_testing_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

//    @Override
//    public void saveUser(UserSaveBean bean) {
//        userService.saveUser(bean);
//    }
}
