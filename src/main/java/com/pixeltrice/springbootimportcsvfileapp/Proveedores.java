package com.pixeltrice.springbootimportcsvfileapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proveedores")
public class Proveedores {

	  @Id
	  @Column(name = "id_proveedor")
	  private long id_proveedor;

	  @Column(name = "nombre")
	  private String nombre;

	  @Column(name = "empresa")
	  private String empresa;

	  @Column(name = "telefono")
	  private long telefono;


	  public Proveedores() {

	  }

	  public Proveedores(long id_proveedor, String nombre, String empresa, long telefono) {
	    this.id_proveedor = id_proveedor;
	    this.nombre = nombre;
	    this.empresa = empresa;
	    this.telefono = telefono;
	  }

	  public long getId_proveedor() {
	    return id_proveedor;
	  }

	  public void setId_proveedor(long id_proveedor) {
	    this.id_proveedor = id_proveedor;
	  }

	  public String getNombre() {
	    return nombre;
	  }

	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }

	  public String getEmpresa() {
	    return empresa;
	  }

	  public void setEmpresa(String empresa) {
	    this.empresa = empresa;
	  }

	  public long isTelefono() {
	    return telefono;
	  }

	  public void  getTelefono(long Telefono) {
	    this.telefono = Telefono;
	  }

	  @Override
	  public String toString() {
	    return "Tutorial [id_proveedor" + id_proveedor + ", nombre=" + nombre + ", empresa=" + empresa + ", telefono=" + telefono + "]";
	  }
	}
