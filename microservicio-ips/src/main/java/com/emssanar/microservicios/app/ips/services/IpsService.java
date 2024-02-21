package com.emssanar.microservicios.app.ips.services;

import java.util.List;


import com.emssanar.microservicios.commons.ips.models.entity.Ips;
import com.emssanar.microservicios.commons.microservicios.services.CommonService;



public interface IpsService extends CommonService<Ips> {
	
	public List<Ips> findByNombreOrApellido(String term);
	
	/*
	public Iterable<Afiliado> findAll();
	public Optional<Afiliado> findById(Long id);
	public Afiliado save(Afiliado afiliado);
	public void delteById(Long id);
	*/


}