package com.dynamic.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="factura")
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private Long id_factura;
	@ManyToOne
	@JoinColumn(name="usuarios")
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="entrega")
	private TipoEntrega tipoEntrega;
	@OneToMany(mappedBy = "factura")
	private List<Detalle> dFacturas;
	@OneToMany(mappedBy = "domicilio")
	private List<Domicilio> fDomicilios;
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}
	public Long getId_factura() {
		return id_factura;
	}
	public void setId_factura(Long id_factura) {
		this.id_factura = id_factura;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}
	public void setTipoEntrega(TipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}
	public List<Detalle> getdFacturas() {
		return dFacturas;
	}
	public void setdFacturas(List<Detalle> dFacturas) {
		this.dFacturas = dFacturas;
	}
	public List<Domicilio> getfDomicilios() {
		return fDomicilios;
	}
	public void setfDomicilios(List<Domicilio> lDomicilios) {
		this.fDomicilios = lDomicilios;
	}
}