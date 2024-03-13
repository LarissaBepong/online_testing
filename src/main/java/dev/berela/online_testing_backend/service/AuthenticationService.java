package dev.berela.online_testing_backend.service;

import dev.berela.online_testing_backend.bean.AuthenticationRequestBean;
import dev.berela.online_testing_backend.bean.AuthenticationResponseBean;

public interface AuthenticationService {

//    AuthenticationResponseBean register(RegisterRequestBean request);

    AuthenticationResponseBean authenticate(AuthenticationRequestBean request);
}
