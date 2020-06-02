package com.dartagnan.springcourse.config;

import com.dartagnan.springcourse.entities.Order;
import com.dartagnan.springcourse.entities.User;
import com.dartagnan.springcourse.repositories.OrderRepository;
import com.dartagnan.springcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//Avisar o Spring que essa é uma classe de configuração
@Configuration
//Avisar que essa classe é uma configuração específica para o perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner { //essa classe  executa as coisas dentro do seu método quando a aplicação for iniciada
    //Para poder salvar os dados no banco de dados precisamos
    //acessar o banco de dados. Quem faz isso é a classe UserRepository
    //então precisamos injetar a dependência de uma forma que garanta desacoplamento (construtor, Factory...)
    //No caso do Spring temos uma injeção de dependência de forma automática através da annotation
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        //Para salvar os dados vamos usar

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); //já instancia o objeto Order associado ao objeto User
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
