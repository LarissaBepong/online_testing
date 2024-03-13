package dev.berela.online_testing_backend.bean;

import dev.berela.online_testing_backend.entity.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveBean {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean active;
    private Role role;
}
