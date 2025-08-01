package com.pressing;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PressingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PressingApplication.class, args);
	}


		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}








