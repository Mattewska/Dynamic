package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceTreporteService;
import com.dynamic.interfaces.InterfaceTreporte;
import com.dynamic.model.TipoReporte;
@Service
public class TreporteService implements InterfaceTreporteService{

	  @Autowired
	private InterfaceTreporte dataTipoReporte;
	
	@Override
	public List<TipoReporte> listar() {
		// TODO Auto-generated method stub
		return dataTipoReporte.findAll();
	}

	@Override
	public Optional<TipoReporte> listarid(long idr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(TipoReporte tr) {
		int res=0;
		TipoReporte tiporeporte=dataTipoReporte.save(tr);
		if(tiporeporte.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(long idr) {
		// TODO Auto-generated method stub
		
	}

}
