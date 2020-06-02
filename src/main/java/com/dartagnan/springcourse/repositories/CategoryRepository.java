package com.dartagnan.springcourse.repositories;

import com.dartagnan.springcourse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//interface que instancia um repositório com as interações necessárias
//@Repository não é necessário pois a  classe herda do JpaRepository a annotation
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //não precisamos criar uma classe que implemente essa interface.
    // O springDataJpa já tem uma implementação padrão para essa interface
}
