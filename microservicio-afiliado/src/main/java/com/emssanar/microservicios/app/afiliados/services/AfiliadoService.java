package com.emssanar.microservicios.app.afiliados.services;

import java.util.List;

import com.emssanar.microservicios.commons.afiliados.models.entity.Afiliado;
import com.emssanar.microservicios.commons.microservicios.services.CommonService;



public interface AfiliadoService extends CommonService<Afiliado> {
	
	public List<Afiliado> findByNombreOrApellido(String term);
	
	/*
	public Iterable<Afiliado> findAll();
	public Optional<Afiliado> findById(Long id);
	public Afiliado save(Afiliado afiliado);
	public void delteById(Long id);
	*/


}
