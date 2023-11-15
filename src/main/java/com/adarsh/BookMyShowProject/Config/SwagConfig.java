package com.adarsh.BookMyShowProject.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SwagConfig {

//	@Bean
//	  public OpenAPI myOpenAPI() {
//	    Server devServer = new Server();
//	    devServer.setUrl("adarsh");
//	    devServer.setDescription("Server URL in Development environment");
//	    
////	    Server prodServer = new Server();
////	    prodServer.setUrl("hi");
////	    prodServer.setDescription("Server URL in Production environment");
//
//	    Contact contact = new Contact();
//	    contact.setEmail("adarshgonela@gmail.com");
//	    contact.setName("adarsh");
//	    contact.setUrl("https://www.adarsh.com");
//
//	    License mitLicense = new License().name("Adarsh License");
//	    		//.url("https://choosealicense.com/licenses/mit/");
//
//	    Info info = new Info()
//	        .title("Book My Show ")
//	        .version("1.0")
//	        .contact(contact)
//	        .description("this app is similar to Bookmyshow")
//	        //.termsOfService("https://www.bezkoder.com/terms")
//	        .license(mitLicense);
//
//	  //  return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
//	    return new OpenAPI().info(info).servers(List.of(devServer));
//		 
//	}
	
	

	
	
	
	
	
	 private static final String SCHEME_NAME = "basicAuth";
	    private static final String SCHEME = "basic";

	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Book My Show Clone Backend")
	                        .version("1.0.0")
	                        .description("this app is similar to Bookmyshow"));
//	                .components(new Components()
//	                        .addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
//	                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
	    }

//	    private SecurityScheme createSecurityScheme() {
//	        return new SecurityScheme()
//	                .name(SCHEME_NAME)
//	                .type(SecurityScheme.Type.HTTP)
//	                .scheme(SCHEME);
//	    }
	
	
	
	
}
