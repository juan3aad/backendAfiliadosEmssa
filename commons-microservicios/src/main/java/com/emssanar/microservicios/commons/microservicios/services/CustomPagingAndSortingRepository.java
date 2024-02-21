package com.emssanar.microservicios.commons.microservicios.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomPagingAndSortingRepository<T, ID> extends CrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
