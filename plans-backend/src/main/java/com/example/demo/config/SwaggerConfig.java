//http://localhost:4545/swagger-ui/index.html

package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
 
@Configuration
public class SwaggerConfig {
 
	   @Bean
	   public OpenAPI defineOpenApi() {
	       Server server = new Server();
	       server.setUrl("http://localhost:4545");
	       server.setDescription("Development");
 
	      
	       Info information = new Info()
	               .title("Telecom Onboarding System")
	               .version("1.0")
	               .description("This API exposes endpoints.");
	               
	       return new OpenAPI().info(information).servers(List.of(server));
	   }
	}