package dev.berela.online_testing_backend.service;

import dev.berela.online_testing_backend.bean.UserSaveBean;
import dev.berela.online_testing_backend.entity.User;

public interface UserService {

    void saveUser(UserSaveBean bean);

    void updateUser(UserSaveBean bean);

    User findByEmail(String email);

    User findById(Long id);
}
