package com.dynamic.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EstadoDomicilio")
public class EstadoDomicilio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estado")
	Long id_estado;
	@Column(name="nombre_estado")
	String nombre_estado;
	@OneToMany(mappedBy="eDomicilios")
	private List<Domicilio> eDomicilio;
	
	//*Getters y Setters
	public Long getId_estado() {
		return id_estado;
	}
	public void setId_estado(Long id_estado) {
		this.id_estado = id_estado;
	}
	public String getNombre_estado() {
		return nombre_estado;
	}
	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	public List<Domicilio> geteDomicilio() {
		return eDomicilio;
	}
	public void seteDomicilio(List<Domicilio> eDomicilio) {
		this.eDomicilio = eDomicilio;
	}
	
	//*Constructores
	public EstadoDomicilio(Long id_estado, String nombre_estado, List<Domicilio> eDomicilio) {
		super();
		this.id_estado = id_estado;
		this.nombre_estado = nombre_estado;
		this.eDomicilio = eDomicilio;
	}
	public EstadoDomicilio() {
		super();
	}
	
	
}