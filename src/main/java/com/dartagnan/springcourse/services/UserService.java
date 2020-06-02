package com.dartagnan.springcourse.services;

import com.dartagnan.springcourse.entities.User;
import com.dartagnan.springcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Component - precisamos registrar o serviço  como componente para para podermos usar a classe no Spring
//@Repository registra um repositório
@Service
public class UserService {

    @Autowired
    private UserRepository repository; //injeção de dependência

    //operação na camada de serviço que passa a chamada para o repository
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get(); //get do Optional retorna o objeto tipo User dentro do obj;
    }
}
