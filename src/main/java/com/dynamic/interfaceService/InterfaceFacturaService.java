package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Factura;

public interface InterfaceFacturaService {
	public List<Factura> listarFactura();
	public List<Factura> idFactura(Long id_factura);
	public Optional<Factura> listarId(Long id);
	public int saveFactura(Factura f);
	public void delete(Long id_factura);
}
