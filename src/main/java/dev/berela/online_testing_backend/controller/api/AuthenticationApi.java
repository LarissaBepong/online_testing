package dev.berela.online_testing_backend.controller.api;

import dev.berela.online_testing_backend.bean.AuthenticationRequestBean;
import dev.berela.online_testing_backend.bean.AuthenticationResponseBean;
import dev.berela.online_testing_backend.bean.UserSaveBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public interface AuthenticationApi {

//    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<AuthenticationResponseBean> register(
//            @RequestBody RegisterRequestBean request
//    );

    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthenticationResponseBean> authenticate(
            @RequestBody AuthenticationRequestBean request
    );

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void saveUser(@RequestBody UserSaveBean bean);

    @PostMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateUser(@RequestBody UserSaveBean bean);
}
