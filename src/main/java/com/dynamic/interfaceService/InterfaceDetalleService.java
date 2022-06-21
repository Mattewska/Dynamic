package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Detalle;

public interface InterfaceDetalleService {
	public List<Detalle>listard();//Metodo Santiago Diaz
	
	public List<Detalle> listarDetalle();
	public Optional<Detalle> searchByid(Long id_detalle);
	public List<Detalle> porIdFactura(Long id_Factura);
	public int saveDetalle(Detalle d);
	public void deleteDetalle(Long id_detalle);
	public void DeleteD(Long id_factura);
	public List<Detalle> listarPorIdFactura(Long id_factura);
	public Void updateDetalleC(Long id_factura, Integer producto, Integer cantidad);
}
