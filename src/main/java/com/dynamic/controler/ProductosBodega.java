package com.dynamic.controler;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dynamic.interfaceService.InterfaceProductoService;
import com.dynamic.model.Producto;



@Controller
@RequestMapping
public class ProductosBodega {
	
	@Autowired
	private InterfaceProductoService service;
	
	@GetMapping("/productosbodega")
	public String listar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos", productos);
		return "productosBodega";	
	}
	
	@RequestMapping("/Cliente")
	public String Cliente() {
		return "Cliente";
	}
	}


