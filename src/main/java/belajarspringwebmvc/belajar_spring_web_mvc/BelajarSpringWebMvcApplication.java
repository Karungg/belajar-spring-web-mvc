package belajarspringwebmvc.belajar_spring_web_mvc;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BelajarSpringWebMvcApplication {

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder builder) {
	// return builder
	// .setConnectTimeout(Duration.ofSeconds(2L))
	// .setReadTimeout(Duration.ofSeconds(2L))
	// .build();
	// }

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringWebMvcApplication.class, args);
	}

}
