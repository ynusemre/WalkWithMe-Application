package com.example.WalkWithMe;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WalkWithMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalkWithMeApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String description,
								 @Value("${application-version}") String version){
		return new OpenAPI()
				.info(new Info()
						.title(" WalkWithMe API")
						.version(version)
						.description(description)
						.license(new License().name(" WalkWithMe API Licence")));
	}

}
