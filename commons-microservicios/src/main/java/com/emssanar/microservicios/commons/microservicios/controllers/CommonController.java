package com.emssanar.microservicios.commons.microservicios.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.emssanar.microservicios.commons.microservicios.services.CommonService;

import jakarta.validation.Valid;



/**
 * La anotación @RestController en Spring Framework se utiliza para marcar una
 * clase como un controlador (controller) de Spring que manejará solicitudes
 * HTTP y devolverá respuestas en el formato de datos adecuado, como JSON o XML
 */

//@RestController // Se anota la clase como un controlador REST
public class CommonController <E, S extends CommonService<E>> {

	@Autowired // Inyección en un campo
	//private S service;
	protected S service; // porque utilizamos herencia para reutilizar el service en el controlador que se implemente
	@GetMapping // proporciona una forma más concisa y específica de manejar solicitudes GET
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/pagina") // proporciona una forma más concisa y específica de manejar solicitudes GET paginable
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping("/{id}") // se proporciona un parametro a la path
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<E> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	/**
	 * @PostMapping se especifica la ruta o URL que activará el método del
	 *              controlador cuando se realice una solicitud POST a esa ruta.
	 * 
	 */
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {// en esta caso la explicación es que los datos que
																// viene en el requesboy se pueble en el objeto alumno
		if(result.hasErrors()) {
			return validar(result);
		}
		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
	protected ResponseEntity<?>  validar(BindingResult result){
		Map<String , Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField()," El campo "+ err.getField() + " " + err.getDefaultMessage());
			
		});
		return ResponseEntity.badRequest().body(errores);
	}
}
