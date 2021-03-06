package com.dartagnan.springcourse.services;

import com.dartagnan.springcourse.entities.Product;
import com.dartagnan.springcourse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Component - precisamos registrar o serviço  como componente para para podermos usar a classe no Spring
//@Repository registra um repositório
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository; //injeção de dependência

    //operação na camada de serviço que passa a chamada para o repository
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get(); //get do Optional retorna o objeto tipo Product dentro do obj;
    }
}
