package com.dynamic.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Usuario;

@Repository
public interface InterfaceUsuario extends CrudRepository<Usuario, Integer> {
	//@Query(value="SELECT * FROM dynamic1.usuario WHERE roles=?;", nativeQuery=true)
	public Usuario findByCorreoAndClave(String correo, String clave);

	
}
