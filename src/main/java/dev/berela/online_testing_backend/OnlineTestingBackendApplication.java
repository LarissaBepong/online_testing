package dev.berela.online_testing_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineTestingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTestingBackendApplication.class, args);
	}

}
