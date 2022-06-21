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


import com.dynamic.interfaceService.InterfaceCategoriaService;
import com.dynamic.interfaceService.InterfaceProductoService;
import com.dynamic.model.Categoria;
import com.dynamic.model.Producto;



@Controller
@RequestMapping
public class ProductoControl {
	
	@Autowired
	private InterfaceProductoService service;
	@Autowired
	private InterfaceCategoriaService serviceC;
	
	
	
	
	@GetMapping("/administrador")
    public String administrador(){
    return "administrador";
    }
	
	@GetMapping("/Carga_Masiva")
	public String carga() {
		return "index";	
	}
	
	@GetMapping("/inventario")
	public String listar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos", productos);
		return "inventario";	
	}
	
	@GetMapping("/Enviar_Correos")
	public String correos() {
		return "EnvioCorreoM";	
	}
	
	@GetMapping("/registroproductos")
	public String nuevo(Model model) {
		List<Categoria> categorias = serviceC.lCategoria();
		model.addAttribute("categorias", categorias);
		model.addAttribute("producto", new Producto());
		return "formproductos";
	}
	
	@PostMapping ("/savep")
	public String save(@Validated Producto p,Model model) {
		service.save(p);
		return "redirect:/inventario";
	}
	
	@GetMapping("/editarp/{id}")
	public String editar(@PathVariable int id, Model model) {
		List<Categoria> categorias = serviceC.lCategoria();
		model.addAttribute("categorias", categorias);
		Optional<Producto>producto=service.listarId(id);
		model.addAttribute("producto", producto);
		return "formproductos";
		
	}
	
	@GetMapping("/eliminarp/{id_producto}")
	public String eliminar(@PathVariable("id_producto") int id) {
		service.eliminar(id);
		return "redirect:/inventario";
	}
	
	//Reporte en PDF
	
	
	}
