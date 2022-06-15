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
@Table(name="detalle")
public class Detalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private Long id_detalle;
	@ManyToOne
	@JoinColumn(name="dFacturas")
	private Factura factura;
	@ManyToOne
	@JoinColumn(name="dProductos")
	private Producto detalleProducto;
	@Column(name="cantidad")
	private Integer cantidad;
	@Column(name="precio")
	private Integer precio;
	@Column(name="preciototal")
	private Integer preciototal;
	
	//*Getters y Setters
	public Long getId_detalle() {
		return id_detalle;
	}
	public Integer getPreciototal() {
		return preciototal;
	}
	public void setPreciototal(Integer preciototal) {
		this.preciototal = preciototal;
	}
	public void setId_detalle(Long id_detalle) {
		this.id_detalle = id_detalle;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Producto getDetalleProducto() {
		return detalleProducto;
	}
	public void setDetalleProducto(Producto detalleProducto) {
		this.detalleProducto = detalleProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	//*Constructores

	

	public Detalle() {
		super();
	}
	
	public Detalle(Long id_detalle, Factura factura, Producto detalleProducto, Integer cantidad, Integer precio,
			Integer preciototal) {
		super();
		this.id_detalle = id_detalle;
		this.factura = factura;
		this.detalleProducto = detalleProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.preciototal = preciototal;
	}
	
	
}
