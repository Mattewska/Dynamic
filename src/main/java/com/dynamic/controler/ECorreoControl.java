package com.dynamic.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dynamic.services.CorreoService;

@Controller
public class ECorreoControl {

	@Autowired
	private CorreoService sendMailService;
	
	@GetMapping("/")
	public String correo() {
	return "PaginaInicio/registro";	
	}
	
	@PostMapping("sendMail")
	public String sendMail (@RequestParam("txtnombre") String nombre, @RequestParam("txtapellido") String apellido, @RequestParam("txtcorreo") String correo, 
	@RequestParam("txtcontraseña") String contraseña, @RequestParam("txtconcontraseña") String confirmar) 
	{
		
		
		String message= "Bienvenid@ " + nombre + " " + apellido + " usted ha sido registrado satisfactoriamente.";
		
		sendMailService.sendMail( "santiva616@gmail.com", correo, "Bienvenido" , message);
		
		return "PaginaInicio/registro";
	}
}
