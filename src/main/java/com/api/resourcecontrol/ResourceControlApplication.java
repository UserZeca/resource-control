package com.api.resourcecontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ResourceControlApplication {

	public static void main(String[] args) {

		SpringApplication.run(ResourceControlApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
