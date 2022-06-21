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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tipo_entrega")
@Getter
@Setter
public class TipoEntrega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tipo_entrega")
	Long tipo_entrega;
	@Column(name="nombre_tipo")
	String nombre_tipo;
	@OneToMany(mappedBy = "tipoEntrega")
	private List<Factura> entrega;
	public Long getTipo_entrega() {
		return tipo_entrega;
	}
	public void setTipo_entrega(Long tipo_entrega) {
		this.tipo_entrega = tipo_entrega;
	}
	public String getNombre_tipo() {
		return nombre_tipo;
	}
	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}
	public TipoEntrega(Long tipo_entrega, String nombre_tipo, List<Factura> entrega) {
		super();
		this.tipo_entrega = tipo_entrega;
		this.nombre_tipo = nombre_tipo;
		this.entrega = entrega;
	}
	public TipoEntrega() {
		super();
	}
	
	
}