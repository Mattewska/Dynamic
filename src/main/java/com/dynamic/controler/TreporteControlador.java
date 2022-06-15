package com.dynamic.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dynamic.interfaceService.InterfaceTreporteService;
import com.dynamic.model.TipoReporte;


@Controller
@RequestMapping
public class TreporteControlador {
	
	@Autowired
	private InterfaceTreporteService service;
	
	@GetMapping("/listartiporeporte")
	public String listar(Model model) {
		List<TipoReporte>tiporeportes=service.listar();
		model.addAttribute("tiporeportes", tiporeportes);
		return "TipoReporte";
	}
	
	@GetMapping("/crearTR")
	public String agregar(Model model) {
		model.addAttribute("tiporeportes", new TipoReporte());
		return "Crear TipoReporte";
	}
	
	public String save(@Validated TipoReporte tr, Model model) {
		service.save(tr);
		return "redirect:/listarTipoReporte";
	}
		
}