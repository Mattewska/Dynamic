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
@Table(name="categoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	Long id_categoria;
	@Column(name="nombre_categoria")
	String nombre;
	@OneToMany(mappedBy = "categoria")
	private List<Producto> categorias;
	public Long getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria(Long id_categoria, String nombre, List<Producto> categorias) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.categorias = categorias;
	}
	public Categoria() {
		super();
	}

}





