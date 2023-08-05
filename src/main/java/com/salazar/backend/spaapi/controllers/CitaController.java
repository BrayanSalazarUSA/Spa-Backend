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

import com.salazar.backend.spaapi.models.entity.Cita;
import com.salazar.backend.spaapi.services.CitaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cita")
public class CitaController {

	@Autowired
	private CitaService service;
	
	@GetMapping
	public List<Cita> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public Cita guardar(@RequestBody Cita cita) {
		return service.save(cita);
	}
	
	@PutMapping("/{id}")
	public Cita editar(@PathVariable Long id,@RequestBody Cita cita) {
		
		Cita citaDb = service.findById(id);
		citaDb.setFecha(cita.getFecha());
		citaDb.setHora(cita.getHora());
		citaDb.setProfesional(cita.getProfesional());
		citaDb.setCliente(cita.getCliente());
		citaDb.setServicios(cita.getServicios());
		citaDb.setEstado(cita.getEstado());
		citaDb.setValorServicio(cita.getValorServicio());
		return service.save(citaDb);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.delete(id);
	}
}
