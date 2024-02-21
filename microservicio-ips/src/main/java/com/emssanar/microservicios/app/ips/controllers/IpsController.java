package com.emssanar.microservicios.app.ips.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emssanar.microservicios.app.ips.services.IpsService;

import com.emssanar.microservicios.commons.ips.models.entity.Ips;
import com.emssanar.microservicios.commons.microservicios.controllers.CommonController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * La anotación @RestController en Spring Framework se utiliza para marcar una
 * clase como un controlador (controller) de Spring que manejará solicitudes
 * HTTP y devolverá respuestas en el formato de datos adecuado, como JSON o XML
 */

@RestController // Se anota la clase como un controlador REST
public class IpsController  extends CommonController<Ips, IpsService>{
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Ips ips, BindingResult result, @PathVariable Long id) {
		
		if(result.hasErrors()) {
			return validar(result);
		}
		
		
		Optional<Ips> o = service.findById(id);// buscar el ips por el id
		if (o.isEmpty()) {// Validamos que exista
			return ResponseEntity.notFound().build();
		}
		
		
		Ips ipsDb = o.get();// Si exite lo traemos con get
		
		ipsDb.setNombre(ips.getNombre());// modificamos el nombre con los datos que vienen en el body que se
												// encuentran en el objeto Afiliado
		ipsDb.setNit(ips.getNit());// modificamos el apellido con los datos que vienen en el body que se
													// encuentran en el objeto Afiliado
		ipsDb.setEmail(ips.getEmail());// modificamos el email con los datos que vienen en el body que se
												// encuentran en el objeto afiliado

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ipsDb));// se guarada el objeto
																						// actualizado y se visualuza en
																						// el body

	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar (@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}
	
	
	
	
	

}
