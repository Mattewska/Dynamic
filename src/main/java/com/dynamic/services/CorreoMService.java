package com.dynamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceUsuarioService;
import com.dynamic.model.Usuario;

@Service
public class CorreoMService {

	// Importante hacer la inyección de dependencia de JavaMailSender:
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private InterfaceUsuarioService data;
	
	// Pasamos por parametro: destinatario, asunto y el mensaje
	public void sendEmail(String from, String subject, String content) {
		List<Usuario>usuarios=data.listar();
		for (Usuario u : usuarios) {
			SimpleMailMessage email = new SimpleMailMessage();

			// recorremos la lista y enviamos a cada cliente el mismo correo
			email.setFrom(from);
			email.setTo(u.getCorreo());
			email.setSubject(subject);
			email.setText(content);

			mailSender.send(email);
		}
	}
}
