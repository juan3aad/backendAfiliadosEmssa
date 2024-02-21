package com.emssanar.microservicios.app.ips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.emssanar.microservicios.commons.ips.models.entity"})
public class MicroservicioIpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioIpsApplication.class, args);
	}

}
