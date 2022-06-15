package com.dynamic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reporte")
public class Reporte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reporte")
	private Integer idReporte;
	@ManyToOne
	@JoinColumn(name="pReporte")
	private Producto pReportes;
	@Column(name="cantidad")
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name="tipoReporte")
	private TipoReporte tipoReportes;
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public Producto getpReportes() {
		return pReportes;
	}
	public void setpReportes(Producto pReportes) {
		this.pReportes = pReportes;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public TipoReporte getTipoReportes() {
		return tipoReportes;
	}
	public void setTipoReportes(TipoReporte tipoReportes) {
		this.tipoReportes = tipoReportes;
	}	

	
}