package com.dynamic.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dynamic.interfaceService.InterfaceDetalleService;
import com.dynamic.interfaceService.InterfaceFacturaService;
import com.dynamic.interfaceService.InterfaceProductoService;
import com.dynamic.model.Detalle;
import com.dynamic.model.Factura;
import com.dynamic.model.Producto;
import com.dynamic.model.Usuario;


@Controller
@RequestMapping
public class DetalleControl {
	
	@Autowired
	private InterfaceDetalleService service;
	@Autowired
	private InterfaceProductoService serviceProducto;
	@Autowired
	private InterfaceFacturaService serviceF;
	@Autowired
	private LoginControl nombre;
	
	
	@GetMapping("/Entregas_en_Curso") //Mi Metodo
	public String listard(Usuario usuario, Model model) {
	List<Detalle>detalles=service.listard();
	model.addAttribute("deta", detalles);
	model.addAttribute("identificador", nombre.identificador);
	return "entregasencurso(detalle)";
	}
	
	@GetMapping("/listarDetalle")
	public String listar(Model model) {
		List<Detalle> detalle = service.listarDetalle();
		model.addAttribute("detalle", detalle);
		return "ventas/listarDetalle";       
	}

	@GetMapping("/editarDetalle/{id_detalle}")
	public String editarDetalle(@PathVariable Long id_detalle, Model model) {
		Optional<Detalle> detalle = service.searchByid(id_detalle);
		List<Producto> productos = serviceProducto.listar();
		model.addAttribute("detalle", detalle);
		model.addAttribute("productos", productos);
		return "ventas/editDetalle";
	}

	@GetMapping("/nuevoDetalle/{id_factura}")
	public String nuevoDetalle(@Valid @PathVariable("id_factura") Long id_factura, Model model) {
		List<Factura> factura = serviceF.idFactura(id_factura);
		List<Detalle> detalleF = service.porIdFactura(id_factura);
		List<Producto> productos = serviceProducto.listar();
		model.addAttribute("detalleF", detalleF);
		model.addAttribute("productos", productos);
		model.addAttribute("factura", factura);
		return "ventas/newDetalle";
	}

	@GetMapping("/eliminarDetalle/{id_detalle}")
	public String delete(@PathVariable("id_detalle") Long id_detalle) {
		service.deleteDetalle(id_detalle);
		System.out.println("se eliminó exitosamente");
		return "redirect:/listarDetalle";
	}

	@GetMapping("/eliminarDetalleF/{id_detalle}")
	public String deleteDF(@PathVariable("id_detalle") Long id_detalle) {
		service.deleteDetalle(id_detalle);
		return "redirect:/detalleFactura";
	}

	@GetMapping("/newDetalle")
	public String newDetalle(Model model) {
		model.addAttribute("detalle", new Detalle());
		return "ventas/newDetalle";
	}

	@PostMapping("/saveDetalle")
	public String saveDetalle(@Validated Detalle d, Model model) {
		service.saveDetalle(d);
		return "redirect:/listarFactura";
	}

	
}