package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Usuario;

public interface InterfaceUsuarioService {
	public List<Usuario>listar();
	
	public Optional<Usuario>listarId(int id);
	
	public int save(Usuario u);
	
	public void eliminar(int id);
	
}
