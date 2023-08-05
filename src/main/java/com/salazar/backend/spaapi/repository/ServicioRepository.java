package com.salazar.backend.spaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.salazar.backend.spaapi.models.entity.Servicio;

public interface ServicioRepository extends CrudRepository<Servicio, Long> {
	@Query("select p from Servicio p where p.nombre like %?1%")
	public List<Servicio> findByNombre(String term);
}
