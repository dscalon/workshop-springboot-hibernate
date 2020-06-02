package com.dartagnan.springcourse.resources;

import com.dartagnan.springcourse.entities.User;
import com.dartagnan.springcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Arquivo que contém os endpoints, ou seja, o arquivo que faz as operações no repositório
@RestController //diz que é uma classe implementada por um contorlador rest
@RequestMapping(value = "/users") //nome do recurso

public class UserResource {

//vamos passar a requisição findAll do controlador REST para a camada de serviços
    @Autowired
    private UserService service; //injeta dependência para a camada de serviço


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list); //retornar sucesso na requisição http com corpo de mensagem user
    }

    @GetMapping(value = "/{id}") //indica que a requisição manda uma id na url
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
