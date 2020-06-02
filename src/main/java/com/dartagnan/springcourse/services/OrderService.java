package com.dartagnan.springcourse.services;

import com.dartagnan.springcourse.entities.Order;
import com.dartagnan.springcourse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Component - precisamos registrar o serviço  como componente para para podermos usar a classe no Spring
//@Repository registra um repositório
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository; //injeção de dependência

    //operação na camada de serviço que passa a chamada para o repository
    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get(); //get do Optional retorna o objeto tipo Order dentro do obj;
    }
}
