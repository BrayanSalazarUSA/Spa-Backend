package com.salazar.backend.spaapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.backend.spaapi.models.entity.Profesional;
import com.salazar.backend.spaapi.repository.ProfesionalRepository;

@Service
public class ProfesionalService {

	@Autowired
	private ProfesionalRepository repository;
	
	public List<Profesional> findAll(){
		return (List<Profesional>) repository.findAll();
	}
	
	public Profesional findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Profesional save(Profesional profesional) {
		return repository.save(profesional);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
