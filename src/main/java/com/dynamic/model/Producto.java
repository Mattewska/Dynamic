package com.dynamic.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="precio")
	private Integer precio;
	@Column(name="stock")
	private Integer stock;
	@ManyToOne
	@JoinColumn(name="categorias")
	private Categoria categoria;
	@OneToMany(mappedBy = "detalleProducto")
	private List<Detalle> dProductos;
	@OneToMany(mappedBy="pReportes")
	private List<Reporte> pReporte;
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Detalle> getdProductos() {
		return dProductos;
	}
	public void setdProductos(List<Detalle> dProductos) {
		this.dProductos = dProductos;
	}
	public List<Reporte> getpReporte() {
		return pReporte;
	}
	public void setpReporte(List<Reporte> pReporte) {
		this.pReporte = pReporte;
	}
	public Producto(int id_producto, String nombre, Integer precio, Integer stock, Categoria categoria,
			List<Detalle> dProductos, List<Reporte> pReporte) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.dProductos = dProductos;
		this.pReporte = pReporte;
	}
	public Producto() {
		super();
	}
	
	
}
