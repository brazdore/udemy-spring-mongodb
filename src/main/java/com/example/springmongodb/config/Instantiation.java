package com.example.springmongodb.config;

import com.example.springmongodb.domain.Post;
import com.example.springmongodb.domain.User;
import com.example.springmongodb.repositories.PostRepository;
import com.example.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User kiara = new User(null, "Takanashi Kiara", "tenchou@kfp.com");
        User gura = new User(null, "Gawr Gura", "a@gmail.com");
        User ame = new User(null, "Amelia Watson", "ame@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/07/2021"), "Where is my Bread?", "I lost my bread!", gura);
        Post p2 = new Post(null, sdf.parse("27/07/2021"), "I found my bread...", "It is a little wet and smells funny, but I will give it a try.", gura);

        postRepository.saveAll(Arrays.asList(p1, p2));
        userRepository.saveAll(Arrays.asList(kiara, gura, ame));
    }
}
