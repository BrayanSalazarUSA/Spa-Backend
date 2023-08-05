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

import com.salazar.backend.spaapi.models.entity.Servicio;
import com.salazar.backend.spaapi.services.ServicioService;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/servicio")
public class ServicioController {
	@Autowired
	private ServicioService service;
	
	@GetMapping
	public List<Servicio> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<Servicio> findByName(@PathVariable String nombre){
		return service.findByName(nombre);
	}
	
	@PostMapping
	public Servicio guardar(@RequestBody Servicio Servicio) {
		return service.save(Servicio);
	}
	
	@PutMapping("/{id}")
	public Servicio editar(@PathVariable Long id, @RequestBody Servicio Servicio) {
		
		Servicio ServicioDb = service.findById(id);
		ServicioDb.setNombre(Servicio.getNombre());
		return service.save(ServicioDb);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.delete(id);
	}
}
