package com.dynamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceRolService;
import com.dynamic.interfaces.InterfaceRol;
import com.dynamic.model.Rol;

@Service
public class RolService implements InterfaceRolService{

	@Autowired
	private InterfaceRol data;
	@Override
	public List<Rol> lRol() {
		return (List<Rol>) data.findAll();
	}

}
