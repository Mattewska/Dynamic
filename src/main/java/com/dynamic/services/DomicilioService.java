package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceDomicilioService;
import com.dynamic.interfaces.InterfaceDomicilio;
import com.dynamic.model.Domicilio;

@Service
public class DomicilioService implements InterfaceDomicilioService{

	@Autowired
	private InterfaceDomicilio data;
	
	@Override
	public List<Domicilio> Listar() {	
	return (List<Domicilio>)data.findAll();
	}

	@Override
	public Optional<Domicilio> ListarID(int id_domicilio) {
		return data.findById(id_domicilio);
	}

	@Override
	public int save(Domicilio domi) {
		int res=0;
		Domicilio domicilio=data.save(domi);
		if(!domicilio.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id_domicilio) {
	data.deleteById(id_domicilio);
	}

	@Override
	public void DeleteDomi(Long id_factura) {
		data.DeleteDomi(id_factura);
	}

	@Override
	public void ActualizarDomi(Integer id_domicilio) {
		data.ActualizarDomi(id_domicilio);
		
	}



}
