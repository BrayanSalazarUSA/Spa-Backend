package com.salazar.backend.spaapi.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;
	
	private String estado;

	@ManyToOne
	// @JsonManagedReference
	@JsonIgnoreProperties("citas")
	private Cliente cliente;

	@ManyToOne
	@JsonIgnoreProperties(value = {"citas"}, allowSetters = true)
	private Profesional profesional;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "cita_servicio", joinColumns = { @JoinColumn(name = "cita_id") }, inverseJoinColumns = {
			@JoinColumn(name = "servicio_id") })
	private List<Servicio> servicios;
	
	private Double valorServicio;
	
	

	public Double getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(Double valorServicio) {
		this.valorServicio = valorServicio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
