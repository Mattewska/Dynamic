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

import com.dynamic.interfaceService.InterfaceDomicilioService;
import com.dynamic.interfaceService.InterfaceEDomicilioService;
import com.dynamic.model.Domicilio;
import com.dynamic.model.EstadoDomicilio;
import com.dynamic.model.Usuario;

@Controller
@RequestMapping
public class DomicilioControl {

	@Autowired
	private InterfaceDomicilioService service;
	@Autowired
	private InterfaceEDomicilioService serviceED;
	@Autowired
	private LoginControl nombre;
	

	@GetMapping("/Historial_Entregas")
	public String Listar(Usuario usuario, Model model) {
		List<Domicilio> domicilios = service.Listar();
		model.addAttribute("domicilios", domicilios);
		model.addAttribute("identificador", nombre.identificador);
		return "historialentregas";
	}

	@GetMapping("/Registrar_Entregas")
	public String agregar(Usuario usuario, Model model) {
		List<EstadoDomicilio> EDomi=serviceED.LEDomi();
		model.addAttribute("EDomi", EDomi);
		model.addAttribute("domicilios", new Domicilio());
		model.addAttribute("identificador", nombre.identificador);
		return "registrarentrega";
	}

	@PostMapping("/save")
	public String save(Usuario usuario, @Validated Domicilio domi, Model model) {
		service.save(domi);
		model.addAttribute("identificador", nombre.identificador);
		return "redirect:/Historial_Entregas";
	}

	@GetMapping("/eliminar/{id_domicilio}")
	public String delete(Usuario usuario,Model model, @PathVariable int id_domicilio) {
		service.delete(id_domicilio);
		model.addAttribute("identificador", nombre.identificador);
		return "redirect:/Historial_Entregas";

	}

	@GetMapping("/editar/{id_domicilio}")
	public String editar(Usuario usuario, @PathVariable("id_domicilio") int id_domicilio, Model model) {
		List<EstadoDomicilio> EDomi=serviceED.LEDomi();
		model.addAttribute("EDomi", EDomi);
		Optional<Domicilio> domicilio = service.ListarID(id_domicilio);
		model.addAttribute("domicilios", domicilio);
		model.addAttribute("identificador", nombre.identificador);
		return "EditarEntrega";
	}
		

	@GetMapping("/Dashboard")
	public String contacto(Usuario usuario, Model model) {
	model.addAttribute("identificador", nombre.identificador);
	return "domiciliario";
	}
}
