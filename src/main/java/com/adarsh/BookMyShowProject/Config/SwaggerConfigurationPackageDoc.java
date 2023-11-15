package com.adarsh.BookMyShowProject.Config;


import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
//@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP, scheme = "basic")

public class SwaggerConfigurationPackageDoc {
	
//	@Bean
//	public Docket api() {
//	    return new Docket(DocumentationType.SWAGGER_2)
//	      .select()
//	      .apis(RequestHandlerSelectors.any())
//	      .paths(PathSelectors.any())
//	      .build();
//	}
	
	
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.adarsh.BookMyShowProject"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	 
}
