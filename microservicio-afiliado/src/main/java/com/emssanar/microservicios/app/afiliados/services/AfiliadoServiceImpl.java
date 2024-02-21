package com.emssanar.microservicios.app.afiliados.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emssanar.microservicios.app.afiliados.models.repository.AfiliadoRepository;
import com.emssanar.microservicios.commons.afiliados.models.entity.Afiliado;
import com.emssanar.microservicios.commons.microservicios.services.CommonServiceImpl;

@Service
public class AfiliadoServiceImpl extends CommonServiceImpl<Afiliado, AfiliadoRepository> implements AfiliadoService {

	@Override
	@Transactional(readOnly = true)
	public List<Afiliado> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}
}