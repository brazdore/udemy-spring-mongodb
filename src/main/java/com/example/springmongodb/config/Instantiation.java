package com.example.springmongodb.config;

import com.example.springmongodb.domain.User;
import com.example.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User kiara = new User(null, "Takanashi Kiara", "tenchou@kfp.com");
        User gura = new User(null, "Gawr Gura", "a@gmail.com");
        User ame = new User(null, "Amelia Watson", "ame@gmail.com");

        userRepository.saveAll(Arrays.asList(kiara, gura, ame));
    }
}
