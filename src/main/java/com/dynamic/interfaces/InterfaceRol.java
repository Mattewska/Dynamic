package com.dynamic.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Rol;

@Repository
public interface InterfaceRol extends CrudRepository<Rol, Long>{
	
}
