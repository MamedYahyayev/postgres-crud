package az.maqa.spring.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PostgresCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresCrudApplication.class, args);
	}

}
