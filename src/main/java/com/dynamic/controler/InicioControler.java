package com.dynamic.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class InicioControler {

	@GetMapping("/Dynamic_System")
	public String ejemplo() {
		return "PaginaInicio/paginicio";	
	}
	
	@GetMapping("/Contactenos")
	public String contacto() {
		return "PaginaInicio/contacto";	
	}
	
	@GetMapping("/Registrarse")
	public String registro() {
		return "PaginaInicio/registro";	
	}

	
	@RequestMapping("/Domiciliario")
    public String Domiciliario(){
        return "domiciliario";
    }
	
	
}
