package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceUsuarioService;
import com.dynamic.interfaces.InterfaceUsuario;
import com.dynamic.model.Usuario;

@Service
public class UsuarioService implements InterfaceUsuarioService {

	@Autowired
	private InterfaceUsuario usuariodata;

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>) usuariodata.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return usuariodata.findById(id);

	}

	@Override
	public int save(Usuario u) {
		int res = 0;
		Usuario usuario = usuariodata.save(u);
		if (!usuario.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		usuariodata.deleteById(id);
	}

}
