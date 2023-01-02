package it.dipartimenti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.dipartimenti.controller","it.dipartimenti.repo","it.dipartimenti.business"})
@EntityScan({"it.dipartimenti.entities"})
@EnableJpaRepositories({"it.dipartimenti.repo"})
public class ServiziApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiziApplication.class, args);
	}

}
