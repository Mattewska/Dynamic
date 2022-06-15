package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Producto;

public interface InterfaceProductoService {
	public List<Producto>listar();
	
	public Optional<Producto> listarId(int id);

	public int save(Producto p);

	public void eliminar(int id);

}

