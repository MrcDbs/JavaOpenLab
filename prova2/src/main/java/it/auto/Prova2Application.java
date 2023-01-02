package it.auto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.auto.controller","it.auto.service","it.auto.repo","it.auto.entities"})
@EntityScan("it.auto.entities")
@EnableJpaRepositories("it.auto.repo")
public class Prova2Application {

	public static void main(String[] args) {
		SpringApplication.run(Prova2Application.class, args);
	}

}
