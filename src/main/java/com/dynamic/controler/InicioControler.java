package com.dynamic.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dynamic.interfaceService.InterfaceRolService;
import com.dynamic.interfaceService.InterfaceUsuarioService;
import com.dynamic.model.Rol;
import com.dynamic.model.Usuario;


@Controller
@RequestMapping
public class InicioControler {
	
	@Autowired
	private InterfaceUsuarioService service;
	@Autowired
	private InterfaceRolService serviceR;

	@GetMapping("/Dynamic_System")
	public String ejemplo() {
		return "PaginaInicio/paginicio";	
	}
	
	@GetMapping("/Contactenos")
	public String contacto() {
		return "PaginaInicio/contacto";	
	}
	
	@GetMapping("/Registrarse")
	public String agregar(Model model) {
		List<Rol> roles = serviceR.lRol();
		model.addAttribute("roles", roles);
		model.addAttribute("usuario", new Usuario());
		return "PaginaInicio/registro";
	}
	
	@PostMapping ("/recliente")
	public String save(@Validated Usuario u,Model model) {
		service.save(u);
		return "redirect:/Iniciar_Sesion";
	}

	@RequestMapping("/Domiciliario")
    public String Domiciliario(){
        return "domiciliario";
    }	
	
}