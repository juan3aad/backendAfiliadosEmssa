package com.emssanar.microservicios.app.afiliados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.emssanar.microservicios.commons.afiliados.models.entity","com.emssanar.microservicios.commons.ips.models.entity"})
public class MicroservicioAfiliadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAfiliadoApplication.class, args);
	}

}
