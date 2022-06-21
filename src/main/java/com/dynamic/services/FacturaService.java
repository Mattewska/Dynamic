package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceFacturaService;
import com.dynamic.interfaces.InterfaceFactura;
import com.dynamic.model.Factura;

@Service 
public class FacturaService implements InterfaceFacturaService{

	@Autowired
	private InterfaceFactura data;
	
	
	@Override
	public List<Factura> listarFactura() {
	return (List<Factura>)data.findAll();
	}

	@Override
	public List<Factura> idFactura(Long id_factura) {
		return (List<Factura>)data.idFactura(id_factura);
	}

	@Override
	public Optional<Factura> listarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveFactura(Factura f) {
		int res=0;
		Factura factura=data.save(f);
		if(!factura.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long id_factura) {
		data.deleteById(id_factura);
		
	}



}
