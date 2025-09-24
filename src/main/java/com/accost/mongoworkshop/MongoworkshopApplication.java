package com.accost.mongoworkshop;

import com.accost.mongoworkshop.domain.User;
import com.accost.mongoworkshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoworkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoworkshopApplication.class, args);
	}


}

