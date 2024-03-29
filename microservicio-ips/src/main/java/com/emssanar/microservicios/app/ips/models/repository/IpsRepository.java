package com.emssanar.microservicios.app.ips.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;


import com.emssanar.microservicios.commons.ips.models.entity.Ips;
import com.emssanar.microservicios.commons.microservicios.services.CustomPagingAndSortingRepository;


public interface IpsRepository extends CustomPagingAndSortingRepository<Ips, Long> {
	@Query("select i from Ips i where i.nombre like %?1%")
	public List<Ips> findByNombreOrApellido(String term);

}