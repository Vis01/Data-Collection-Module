package com.cdac.Acts.DataCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cdac.Acts.Controllers","com.cdac.Acts.Services","com.cdac.Acts.DataCollection"})
@EntityScan(basePackages = {"com.cdac.Acts.entities"})
@EnableJpaRepositories(basePackages = {"com.cdac.Acts.Repositories"})
public class DataCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectionApplication.class, args);
	}

}
