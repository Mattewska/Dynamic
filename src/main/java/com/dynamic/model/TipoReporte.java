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
@Table(name="tipo_reporte")
public class TipoReporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_reporte")
	private Long idTipoReporte;
	@Column(name="nombre_reporte")
	private String nombreReporte;
	@OneToMany(mappedBy="tipoReportes")
	private List<Reporte> tipoReporte;
	public Long getIdTipoReporte() {
		return idTipoReporte;
	}
	public void setIdTipoReporte(Long idTipoReporte) {
		this.idTipoReporte = idTipoReporte;
	}
	public String getNombreReporte() {
		return nombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
}