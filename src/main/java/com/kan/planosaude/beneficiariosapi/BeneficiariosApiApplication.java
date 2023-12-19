package com.kan.planosaude.beneficiariosapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Beneficiários API", version = "v1.0", description = "Api de Beneficiários Ekan"))
@SpringBootApplication
public class BeneficiariosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiariosApiApplication.class, args);
	}

}
