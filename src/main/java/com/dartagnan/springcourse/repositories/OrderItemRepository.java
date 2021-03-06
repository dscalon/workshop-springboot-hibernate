package com.dartagnan.springcourse.repositories;

import com.dartagnan.springcourse.entities.OrderItem;
import com.dartagnan.springcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//interface que instancia um repositório com as interações necessárias
//@Repository não é necessário pois a  classe herda do JpaRepository a annotation
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    //não precisamos criar uma classe que implemente essa interface.
    // O springDataJpa já tem uma implementação padrão para essa interface
}
