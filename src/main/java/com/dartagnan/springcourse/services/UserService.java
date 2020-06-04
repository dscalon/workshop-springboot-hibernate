package com.dartagnan.springcourse.services;

import com.dartagnan.springcourse.entities.User;
import com.dartagnan.springcourse.repositories.UserRepository;
import com.dartagnan.springcourse.services.exceptions.DatabaseException;
import com.dartagnan.springcourse.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //se não der get ele joga a excepion escolhida na expressão lambda
    }

    public User insert(User obj){
        return repository.save(obj); //repository.save já retorna o objeto salvo por padrão
    }

    public void delete(Long id){
       try {
           repository.deleteById(id);
       }
       catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
       }
       catch (DataIntegrityViolationException e){
           throw new DatabaseException(e.getMessage()); //troca excessão do servidor/banco de dados por uma exceção da camada de serviço
       }
    }

    public User update(Long id, User obj){ //Id para dizer qual vai ser atualizado e obj com os dados
        User entity = repository.getOne(id); //cria em memória um objeto monitorado pelo JPA sem ir até o banco de dados para trabalhar com ele
        updateData(entity, obj);
        return repository.save(entity);

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        //nesse update não vamos deixar atualizar o Id nem a senha
    }
}
