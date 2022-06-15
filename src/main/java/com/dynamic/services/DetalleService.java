package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceDetalleService;
import com.dynamic.interfaces.InterfaceDetalle;
import com.dynamic.model.Detalle;

@Service
public class DetalleService implements InterfaceDetalleService{

	@Autowired
	private InterfaceDetalle datos;
	
	@Override
	public List<Detalle> listard() { //Mi Metodo
	return (List<Detalle>)datos.findAll();
	}

	@Override
	public List<Detalle> listarDetalle() {
		return (List<Detalle>)datos.findAll();
	}

	@Override
	public Optional<Detalle> searchByid(Long id_detalle) {
		return datos.findById(id_detalle);
	}

	@Override
	public List<Detalle> porIdFactura(Long id_Factura) {
		return datos.porIdFactura(id_Factura);
	}

	@Override
	public int saveDetalle(Detalle d) {
		int res=0;
		Detalle detalle=datos.save(d);
		if(!detalle.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteDetalle(Long id_detalle) {
		datos.deleteById(id_detalle);		
	}

	@Override
	public List<Detalle> listarPorIdFactura(Long id_factura) {
		return datos.listarPorIdFactura(id_factura);
	}

	@Override
	public Void updateDetalleC(Long id_factura, Integer producto, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteD(Long id_factura) {
		datos.DeleteD(id_factura);
	}
}
