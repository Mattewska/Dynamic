package com.dynamic.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dynamic.interfaceService.InterfaceDetalleService;
import com.dynamic.interfaceService.InterfaceFacturaService;
import com.dynamic.interfaceService.InterfaceUsuarioService;
import com.dynamic.model.Detalle;
import com.dynamic.model.Factura;
import com.dynamic.model.Usuario;

@Controller
@RequestMapping
public class FacturaControl {


	@Autowired
	private InterfaceFacturaService service;
	@Autowired
	private InterfaceDetalleService serviceD;
	@Autowired
	private InterfaceUsuarioService serviceU;
	
	@GetMapping("/vendedor")
	public String vendedor(Model model) {
		return "ventas/vendedor";
	}
	
	/*@GetMapping("/listar/{id_factura}")
	public String listarDetalles(Model model, @PathVariable("id_factura") Long id_factura) {
		List<Detalle> detalleF = serviceD.listarPorIdFactura(id_factura);
		model.addAttribute("detalleF", detalleF);
		return "ventas/detalleFactura";     
	}*/
	
	@GetMapping("/listar/{id_factura}")
	public ModelAndView listarf(@PathVariable("id_factura") Long id_factura) 
	{
		List<Detalle> detalleF = serviceD.listarPorIdFactura(id_factura);
		ModelAndView mv = new ModelAndView("ventas/detalleFactura");
		mv.addObject("detalleF", detalleF);
		return mv;
	}
	
	@GetMapping("/listarFactura")
	public String listarFactura(Model model) {
		List<Factura> facturas=service.listarFactura();
		model.addAttribute("facturas", facturas);
		return "ventas/listarFactura";
	}
	
	@GetMapping("/newFactura")
	public String agregarFactura(Model model) {
		List<Usuario>usuarios=serviceU.listar();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("factura", new Factura());
		return "ventas/nuevaFactura";
	}
	
	@PostMapping("/saveFactura")
	public String saveFactura(@Validated Factura f, Model model) {
		service.saveFactura(f);
		return "redirect:/listarFactura";
	}
	
	@GetMapping("/eliminarFactura/{id_factura}")
	public String delete(@PathVariable("id_factura") Long id_factura) {
		//serviceDo.DeleteDomi(id_factura);
		//serviceD.DeleteD(id_factura);
		service.delete(id_factura);
		return "/listarFactura";
	}
	
}
