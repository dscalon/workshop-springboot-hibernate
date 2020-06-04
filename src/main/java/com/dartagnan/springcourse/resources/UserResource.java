package com.dartagnan.springcourse.resources;

import com.dartagnan.springcourse.entities.User;
import com.dartagnan.springcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Arquivo que contém os endpoints, ou seja, o arquivo que faz as operações no repositório
@RestController //diz que é uma classe implementada por um contorlador rest
@RequestMapping(value = "/users") //nome do recurso
public class UserResource {

//vamos passar a requisição findAll do controlador REST para a camada de serviços
    @Autowired
    private UserService service; //injeta dependência para a camada de serviço


    @GetMapping  //Instrução para o postman. Se não passar nada para o Postman ele retorna o que está aqui
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list); //retornar sucesso na requisição http com corpo de mensagem user
    }

    @GetMapping(value = "/{id}") //indica que a requisição manda uma id na url. Retorna users/id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){ //RequestBody faz a desserialização dos dados para incluir no objeto
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //O path vai ser criado automaticamente com esse comando
        return ResponseEntity.created(uri).body(obj);//resposta padrão que significa que
        // um novo recurso foi criado. Precisa de um enderço de URI de retorno (Ou seja, precisamos de um cabeçalho chamado location com o endereço do recurso criado


    }
}
