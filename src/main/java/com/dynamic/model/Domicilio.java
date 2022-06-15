package com.dynamic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_domicilio")
	int id_domicilio;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_domicilio")
	private Date fecha_domicilio;
	@ManyToOne
	@JoinColumn(name="fDomicilios")
	Factura domicilio;
	@ManyToOne
	@JoinColumn(name="eDomicilio")
	EstadoDomicilio eDomicilios;
	@PrePersist
	public void prePersist() {
		this.fecha_domicilio = new Date();
	}
	
	//*Getters y Setters
	public int getId_domicilio() {
		return id_domicilio;
	}
	public void setId_domicilio(int id_domicilio) {
		this.id_domicilio = id_domicilio;
	}
	public Date getFecha_domicilio() {
		return fecha_domicilio;
	}
	public void setFecha_domicilio(Date fecha_domicilio) {
		this.fecha_domicilio = fecha_domicilio;
	}
	public Factura getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Factura domicilio) {
		this.domicilio = domicilio;
	}
	public EstadoDomicilio geteDomicilios() {
		return eDomicilios;
	}
	public void seteDomicilios(EstadoDomicilio eDomicilios) {
		this.eDomicilios = eDomicilios;
	}
	
	
	//*Constructores
	public Domicilio(int id_domicilio, Date fecha_domicilio, Factura domicilio, EstadoDomicilio eDomicilios) {
		super();
		this.id_domicilio = id_domicilio;
		this.fecha_domicilio = fecha_domicilio;
		this.domicilio = domicilio;
		this.eDomicilios = eDomicilios;
	}
	public Domicilio() {
		super();
	}
	
	
	
}

