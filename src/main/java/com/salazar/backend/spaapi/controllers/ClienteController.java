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

import com.salazar.backend.spaapi.models.entity.Cliente;
import com.salazar.backend.spaapi.services.ClienteService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<Cliente> findByName(@PathVariable String nombre){
		return service.findByName(nombre);
	}
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@PostMapping
	public Cliente guardar(@RequestBody Cliente cliente) {
		System.out.println(cliente);
		return service.guardar(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente editar(@PathVariable Long id, @RequestBody Cliente cliente) {
		
		Cliente clienteDb = service.findById(id);
		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setApellido(cliente.getApellido());
		clienteDb.setTelefono(cliente.getTelefono());
		return service.guardar(clienteDb);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		service.delete(id);
	}
	
}
