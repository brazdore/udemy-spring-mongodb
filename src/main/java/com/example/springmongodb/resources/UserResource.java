package com.example.springmongodb.resources;

import com.example.springmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User kiara = new User("1", "Kiara", "phoenix@kfp.com");
        User nenechi = new User("2", "Nenechi", "neneseal@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(kiara, nenechi));
        return ResponseEntity.ok().body(list);
    }
}
