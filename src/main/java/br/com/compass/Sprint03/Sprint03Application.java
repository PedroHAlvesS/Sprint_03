package br.com.compass.Sprint03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class Sprint03Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint03Application.class, args);
	}

}
