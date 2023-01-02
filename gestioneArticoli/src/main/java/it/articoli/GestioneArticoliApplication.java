package it.articoli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.articoli.controller","it.articoli.entities","it.articoli.repo","it.articoli.service"})
@EntityScan({"it.articoli.entities"})
@EnableJpaRepositories({"it.articoli.repo"})
public class GestioneArticoliApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneArticoliApplication.class, args);
	}

}
