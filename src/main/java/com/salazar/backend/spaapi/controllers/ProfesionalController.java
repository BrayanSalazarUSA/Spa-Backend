package com.salazar.backend.spaapi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salazar.backend.spaapi.models.entity.Profesional;
import com.salazar.backend.spaapi.services.ProfesionalService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/profesional")
public class ProfesionalController {
	
	@Autowired
	private ProfesionalService service;
	
	@GetMapping
	public List<Profesional> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Profesional guardar(@RequestBody Profesional Profesional) {
		return service.save(Profesional);
	}
	
	@PutMapping("/{id}")
	public Profesional editar(@RequestBody Profesional profesional, @PathVariable Long id) {
		
		Profesional ProfesionalDb = service.findById(id);
		ProfesionalDb.setNombre(profesional.getNombre());
		ProfesionalDb.setApellido(profesional.getApellido());
		ProfesionalDb.setColor(profesional.getColor());
		//ProfesionalDb.setCitas(profesional.getCitas());
		return service.save(ProfesionalDb);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.delete(id);
	}
}
