package com.emssanar.microservicios.app.ips.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emssanar.microservicios.app.ips.models.repository.IpsRepository;

import com.emssanar.microservicios.commons.ips.models.entity.Ips;
import com.emssanar.microservicios.commons.microservicios.services.CommonServiceImpl;

@Service
public class IpsServiceImpl extends CommonServiceImpl<Ips, IpsRepository> implements IpsService {

	@Override
	@Transactional(readOnly = true)
	public List<Ips> findByNombreOrApellido(String term) {
		
		return repository.findByNombreOrApellido(term);
	}
}