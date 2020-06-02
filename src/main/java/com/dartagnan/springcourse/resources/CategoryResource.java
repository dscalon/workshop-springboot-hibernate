package com.dartagnan.springcourse.resources;

import com.dartagnan.springcourse.entities.Category;
import com.dartagnan.springcourse.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Arquivo que contém os endpoints, ou seja, o arquivo que faz as operações no repositório
@RestController //diz que é uma classe implementada por um contorlador rest
@RequestMapping(value = "/categories") //nome do recurso

public class CategoryResource {

//vamos passar a requisição findAll do controlador REST para a camada de serviços
    @Autowired
    private CategoryService service; //injeta dependência para a camada de serviço


    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();

        return ResponseEntity.ok().body(list); //retornar sucesso na requisição http com corpo de mensagem Category
    }

    @GetMapping(value = "/{id}") //indica que a requisição manda uma id na url
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
