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
@Table(name="rol")

public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long idRol;
	@Column(name="rol", length=40)
	private String rolName;
	@OneToMany(mappedBy = "rol")
	public List<Usuario> roles;
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getRolName() {
		return rolName;
	}
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
	public Rol(Long idRol, String rolName, List<Usuario> roles) {
		super();
		this.idRol = idRol;
		this.rolName = rolName;
		this.roles = roles;
	}
	public Rol() {
		super();
	}
	
	
	
}