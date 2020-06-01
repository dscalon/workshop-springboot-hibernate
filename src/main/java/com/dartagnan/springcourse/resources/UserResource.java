package com.dartagnan.springcourse.resources;

import com.dartagnan.springcourse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //diz que é uma classe implementada por um contorlador rest
@RequestMapping(value = "/users") //nome do recurso
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Maria", "maria@gmail.com", "9999999","12345");

        return ResponseEntity.ok().body(user); //retornar sucesso na requisição http com corpo de mensagem user
    }
}
