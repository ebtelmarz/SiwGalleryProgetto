package it.uniroma3.SiwGalleryProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import it.uniroma3.exception.StorageProperties;
import it.uniroma3.services.StorageService;

@SpringBootApplication
@ComponentScan(basePackages="it.uniroma3.controller")
@EnableJpaRepositories(basePackages="it.uniroma3.repositories")
@EntityScan("it.uniroma3.model")
@EnableConfigurationProperties(StorageProperties.class)

public class SiwGalleryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiwGalleryProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
}
