package com.emssanar.microservicios.commons.microservicios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.transaction.annotation.Transactional;





public class CommonServiceImpl<E, R extends CustomPagingAndSortingRepository<E, Long>> implements CommonService<E> {

	
	//Se procede a inyectar el repositorio con la anotación @Autowired
	@Autowired
	protected R repository;
	
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repository.findAll(); // Ordenar por id ascendente
    }
	

	@Override
	@Transactional(readOnly = true)//como es una consulta se deja con esta anotacion de solo lectura
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional//Para este caso si se permite escritura
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		 
		return repository.findAll(pageable);
	}

}