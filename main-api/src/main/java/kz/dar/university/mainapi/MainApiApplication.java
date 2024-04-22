package kz.dar.university.mainapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApiApplication.class, args);
	}

}
