package school.sptech.primeiro_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PrimeiroProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);
	}
}
