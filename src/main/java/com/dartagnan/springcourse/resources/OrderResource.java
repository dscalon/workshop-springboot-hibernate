package com.dartagnan.springcourse.resources;

import com.dartagnan.springcourse.entities.Order;
import com.dartagnan.springcourse.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Arquivo que contém os endpoints, ou seja, o arquivo que faz as operações no repositório
@RestController //diz que é uma classe implementada por um contorlador rest
@RequestMapping(value = "/orders") //nome do recurso

public class OrderResource {

//vamos passar a requisição findAll do controlador REST para a camada de serviços
    @Autowired
    private OrderService service; //injeta dependência para a camada de serviço


    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();

        return ResponseEntity.ok().body(list); //retornar sucesso na requisição http com corpo de mensagem Order
    }

    @GetMapping(value = "/{id}") //indica que a requisição manda uma id na url
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
