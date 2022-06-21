package com.dynamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceCategoriaService;
import com.dynamic.interfaces.InterfaceCategoria;
import com.dynamic.model.Categoria;

@Service
public class CategoriaService implements InterfaceCategoriaService{

	@Autowired
	private InterfaceCategoria data;
	
	@Override
	public List<Categoria> lCategoria() {
		return (List<Categoria>)data.findAll();
	}

}
