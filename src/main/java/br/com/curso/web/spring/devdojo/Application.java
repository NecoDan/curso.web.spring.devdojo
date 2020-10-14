package br.com.curso.web.spring.devdojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableTransactionManagement
@EntityScan("br.com.curso.web.spring.devdojo.model")*/
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
