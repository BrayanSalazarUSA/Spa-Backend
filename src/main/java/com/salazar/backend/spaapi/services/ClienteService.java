package com.salazar.backend.spaapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salazar.backend.spaapi.models.entity.Cliente;
import com.salazar.backend.spaapi.repository.ClienteRepository;

@Service
public class ClienteService{
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return (List<Cliente>) repository.findAll();
	}
	
	public List<Cliente> findByName(String nombre){
		return (List<Cliente>) repository.findByNombre(nombre);
	}
	
	public Cliente findById(Long id){
		return repository.findById(id).orElse(null);
	}
	@Transactional
	public Cliente guardar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	
	
}
