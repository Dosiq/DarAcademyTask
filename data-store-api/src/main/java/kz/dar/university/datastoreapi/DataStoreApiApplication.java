package kz.dar.university.datastoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "kz.dar.university.datastoreapi.repositories")
public class DataStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataStoreApiApplication.class, args);
	}

}
