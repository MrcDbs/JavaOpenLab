package it.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"it.app2.web","it.app2.components","it.backend.service",
"it.backend.repository"})
@EnableJpaRepositories({"it.backend.repository"})
@EntityScan({"it.backend.entity"})
@Import({it.app2.config.ProjectConfigSecurity.class})
public class App2Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}

}
