package com.dynamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceEDomicilioService;
import com.dynamic.interfaces.InterfaceEDomicilio;
import com.dynamic.model.EstadoDomicilio;

@Service
public class EDomicilioService implements InterfaceEDomicilioService{

	@Autowired
	private InterfaceEDomicilio data;
	@Override
	public List<EstadoDomicilio> LEDomi() {
		return (List<EstadoDomicilio>) data.findAll();
	}

}
