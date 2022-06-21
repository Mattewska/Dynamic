package com.dynamic.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dynamic.interfaces.InterfaceUsuario;
import com.dynamic.model.Usuario;

@Controller
@RequestMapping
public class LoginControl {

	@Autowired
	private InterfaceUsuario IU;
	
	 Usuario identificador;
	
	@GetMapping("/Iniciar_Sesion")
	public String identificador(Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/Inicio")
	public String login(Usuario usuario, Model model, RedirectAttributes attribute) {
		Usuario verificar = IU.findByCorreoAndClave(usuario.getCorreo(),usuario.getClave());
		
		model.addAttribute("usuario", verificar);
		model.addAttribute("identificador", identificador);
		
		if(verificar != null) {
			if(verificar.getRol().getRolName().equals("Administrador")) {
				identificador=verificar;
				model.addAttribute("identificador", identificador);
				return "administrador";
			}else if(verificar.getRol().getRolName().equals("Vendedor")) {
				identificador=verificar;
				model.addAttribute("identificador", identificador);
				return "ventas/vendedor";
			}else if(verificar.getRol().getRolName().equals("Encargado de Bodega")) {
				identificador=verificar;
				model.addAttribute("identificador", identificador);
				return "bodega";
			}else if(verificar.getRol().getRolName().equals("Cliente")) {
				identificador=verificar;
				model.addAttribute("identificador", identificador);
				return "Cliente";	
			}if(verificar.getRol().getRolName().equals("Domiciliario")) {
				identificador=verificar;
				model.addAttribute("identificador", identificador);
				return "domiciliario";
		}
		return "redirect:/Iniciar_Sesion";
	}else {
		
		attribute.addFlashAttribute("error", "Este usuario no está registrado en el sistema, por favor registrese o verifique sus credenciales");
		return "redirect:/Iniciar_Sesion";
	}
		
	
		

}	

}