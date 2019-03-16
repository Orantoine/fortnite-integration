package fr.orantoine.fortniteintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FortniteIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortniteIntegrationApplication.class, args);
	}

}
