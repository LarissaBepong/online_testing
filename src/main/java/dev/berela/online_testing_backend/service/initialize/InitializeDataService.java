package dev.berela.online_testing_backend.service.initialize;

import dev.berela.online_testing_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitializeDataService {
    private final UserRepository userRepository;

//    @PostConstruct
//    public void init() {
//        saveUser();
//    }
//
//
//    private void saveUser() {
//        User user = new User();
//        if (userRepository.findByLogin("larissa").isEmpty()) {
//            user.setName("LARISSA");
//            user.setLogin("larissa");
//            user.setEmail("larissa@berela.cm");
//            user.setPassword("12345");
//            List<String> roleListName = new ArrayList<>(Collections.singletonList("ROLE_ADMIN"));
//            user.setRole(roleRepository.findByListName(roleListName));
//        } else {
//            User user1 = userRepository.findByLogin("larissa").get();
//        }
//    }
}
