package it.tris.scacchiera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.tris.scacchiera.controller","it.tris.scacchiera.repo","it.tris.scacchiera.service","it.tris.scacchiera.utils"})
@EntityScan({"it.tris.scacchiera.entities"})
@EnableJpaRepositories({"it.tris.scacchiera.repo"})
public class ScacchieraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScacchieraApplication.class, args);
	}

}
