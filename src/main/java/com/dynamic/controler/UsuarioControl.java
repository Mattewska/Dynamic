package com.dynamic.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dynamic.interfaceService.InterfaceRolService;
import com.dynamic.interfaceService.InterfaceUsuarioService;
import com.dynamic.model.Rol;
import com.dynamic.model.Usuario;

@Controller
@RequestMapping
 class UsuarioControl{

	@Autowired
	private InterfaceUsuarioService service;
	@Autowired
	private InterfaceRolService serviceR;
	
	//private Usuario inicio;
	
	
	@GetMapping("/empleados")
	public String listar(Model model) {
		List<Usuario>usuarios=service.listar();
		model.addAttribute("usuarios", usuarios);
		return"empleados";
	}
	
	@GetMapping("/registrarempleados")
	public String agregar(Model model) {
		List<Rol> roles = serviceR.lRol();
		model.addAttribute("roles", roles);
		model.addAttribute("usuario", new Usuario());
		return "registrarempleados";
	}
	
	@PostMapping ("/salvar")
	public String save(@Validated Usuario u,Model model) {
		service.save(u);
		return "redirect:/empleados";
	}
	
	@GetMapping("/edit/{id_producto}")
	public String editar(@PathVariable("id_producto")int id, Model model) {
		List<Rol> roles = serviceR.lRol();
		model.addAttribute("roles", roles);
		Optional<Usuario>usruario=service.listarId(id);
		model.addAttribute("usuario", usruario);
		return "resgistrarempleados";
	}
	
	@GetMapping("/eliminaru/{id_usuario}")
	public String eliminar(@PathVariable("id_usuario") int id) {
		service.eliminar(id);
		return "redirect:/empleados";
	}
	
	
	}
