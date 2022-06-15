package com.dynamic.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dynamic.services.CorreoMService;

@Controller
public class CorreoMControl {

	@Autowired
	private CorreoMService SendMasiveMailService;
	
	//@GetMapping("/edit/{id_producto}")
	//public String editar(@PathVariable("id_producto")int id, Model model)
	
	@GetMapping("/MasiveMail")
	public String sendEMail (@RequestParam("asunto")String subject, @RequestParam("mensaje")String content) 
	{

		
		SendMasiveMailService.sendEmail("wolverineinmortal127@gmail.com", subject, content); 
		
		return "EnvioCorreoM";
	}
}
