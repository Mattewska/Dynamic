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

import com.dynamic.interfaceService.InterfaceProductoService;
import com.dynamic.interfaceService.InterfaceReporteService;
import com.dynamic.interfaceService.InterfaceTreporteService;
import com.dynamic.model.Producto;
import com.dynamic.model.Reporte;
import com.dynamic.model.TipoReporte;

@Controller
@RequestMapping
public class ReporteControl {

	@Autowired
	private InterfaceReporteService service;
	@Autowired
	private InterfaceProductoService serviceProducto;
	@Autowired
	private InterfaceTreporteService serviceTR;

	@GetMapping("/listarReporte")
	public String listar(Model model) {
		List<Reporte> reportes = service.listar();
		model.addAttribute("reportes", reportes);
		return "Reporte";

	}

	@GetMapping("/CrearReporte")
	public String saveReporte(Model model) {
		List<Producto> productos = serviceProducto.listar();
		List<TipoReporte> tReporte = serviceTR.listar();
		model.addAttribute("tReporte", tReporte);
		model.addAttribute("reportes", new Reporte());
		model.addAttribute("productos", productos);
		return "CrearReporte";
	}

	@PostMapping("/saveReporte")
	public String saveReporte(@Validated Reporte r, Model model) {
		service.saveReporte(r);
		return "redirect:listarReporte";
	}

	@GetMapping("/editarReporte/{idReporte}")
	public String editarReporte(@PathVariable("idReporte") int id, Model model) {
		Optional<Reporte> reporte = service.listarId(id);
		List<Producto> productos = serviceProducto.listar();
		List<TipoReporte> tReporte = serviceTR.listar();
		model.addAttribute("reportes", reporte);
		model.addAttribute("tReporte", tReporte);
		model.addAttribute("productos", productos);
		return "CrearReporte";

	}

	@GetMapping("/eliminarReporte/{idReporte}")
	public String eliminarReporte(@PathVariable("idReporte") int id) {
		service.eliminarReporte(id);
		return "redirect:listarReporte";
	}

	@RequestMapping("/bodega")
	public String bodega() {
		return "bodega";
	}

}