package com.emssanar.microservicios.app.afiliados.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.emssanar.microservicios.commons.afiliados.models.entity.Afiliado;
import com.emssanar.microservicios.commons.microservicios.services.CustomPagingAndSortingRepository;


public interface AfiliadoRepository extends CustomPagingAndSortingRepository<Afiliado, Long> {
	@Query("select a from Afiliado a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Afiliado> findByNombreOrApellido(String term);

}