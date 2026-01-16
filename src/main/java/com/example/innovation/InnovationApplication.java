package com.example.innovation;

import com.example.innovation.dto.UserReqDto;
import com.example.innovation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InnovationApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InnovationApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    /*    userService.addUser(
                new UserReqDto(
                        "stranger",
                        "stranger42351",
                        "Logesh",
                        "Ravi",
                        "ADMIN"
                )
        );*/
    }
}
