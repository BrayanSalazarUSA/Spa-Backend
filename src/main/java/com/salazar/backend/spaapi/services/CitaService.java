package com.salazar.backend.spaapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.backend.spaapi.models.entity.Cita;
import com.salazar.backend.spaapi.repository.CitaRepository;
@Service
public class CitaService {

	@Autowired
	private CitaRepository repository;
	
	public List<Cita> findAll(){
		return (List<Cita>) repository.findAll();
	}
	
	public Cita findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Cita save(Cita cita) {
		return repository.save(cita);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
