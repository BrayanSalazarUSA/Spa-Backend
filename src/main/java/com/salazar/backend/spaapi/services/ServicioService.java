package com.salazar.backend.spaapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.backend.spaapi.models.entity.Servicio;
import com.salazar.backend.spaapi.repository.ServicioRepository;

@Service
public class ServicioService {

	@Autowired
	private ServicioRepository repository;
	
	public List<Servicio> findAll(){
		return (List<Servicio>) repository.findAll();
	}
	
	public Servicio findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public List<Servicio> findByName(String nombre){
		return (List<Servicio>) repository.findByNombre(nombre);
	}
	
	public Servicio save(Servicio servicio) {
		return repository.save(servicio);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
