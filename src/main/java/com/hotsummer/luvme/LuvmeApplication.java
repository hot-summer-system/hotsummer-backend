package com.hotsummer.luvme;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

//https://hot-summer-service.onrender.com
//http://localhost:8080
@SpringBootApplication
@SecurityScheme(name = "token_auth", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, scheme = "bearer", bearerFormat = "JWT")
@OpenAPIDefinition(info = @Info(title = "API Doc for LuvMe Web Service", description = "This is list of endpoints and documentations of REST API for LuvMe Web Service", version = "1.0"), servers = {
		@Server(url = "http://localhost:8080", description = "Local development server domain") }, security = {
				@SecurityRequirement(name = "token_auth") })
public class LuvmeApplication {

	public LuvmeApplication() {
	}

	@Primary
	@Bean
	public void initFirebase() throws IOException {
		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials
						.fromStream(this.getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json")))
				.build();
		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(LuvmeApplication.class, args);
	}

}
