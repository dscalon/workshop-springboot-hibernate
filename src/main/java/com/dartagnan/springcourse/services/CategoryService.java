package com.dartagnan.springcourse.services;

import com.dartagnan.springcourse.entities.Category;
import com.dartagnan.springcourse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Component - precisamos registrar o serviço  como componente para para podermos usar a classe no Spring
//@Repository registra um repositório
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository; //injeção de dependência

    //operação na camada de serviço que passa a chamada para o repository
    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get(); //get do Optional retorna o objeto tipo Category dentro do obj;
    }
}
