package br.com.fiap.Checkpoint1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Checkpoint 1 Java"))
public class Checkpoint1Application {

	public static void main(String[] args) {SpringApplication.run(Checkpoint1Application.class, args);
	}

}
