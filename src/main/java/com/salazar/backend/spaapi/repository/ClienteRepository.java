package com.salazar.backend.spaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.salazar.backend.spaapi.models.entity.Cliente;
import com.salazar.backend.spaapi.models.entity.Servicio;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	@Query("select p from Cliente p where p.nombre like %?1%")
	public List<Cliente> findByNombre(String term);
}
