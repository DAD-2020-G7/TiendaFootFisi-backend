package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.service.impl.ClienteServicioImpl;
import com.footfisi.tienda.service.impl.PersonaServicioImpl;
import com.footfisi.tienda.service.impl.UsuarioServicioImpl;

@CrossOrigin
@RestController
public class ClienteController {
	@Autowired
	@Qualifier("personaService")
	private PersonaServicioImpl personaServicio;
	@Autowired
	@Qualifier("clienteService")
	private ClienteServicioImpl clienteServicio;
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServicioImpl usuarioServicio;
		
	@PostMapping("/api/cliente/registrar")
	public MensajeForm registrarCliente(@RequestBody UsuarioClienteForm oClienteForm) {
		personaServicio.registrarPersonaCliente(oClienteForm);
		clienteServicio.registrarCliente(oClienteForm);
		usuarioServicio.registrarUsuarioCliente(oClienteForm);
		
		MensajeForm mensaje = new MensajeForm();
		mensaje.setsTipo("1");
		mensaje.setsMensaje("Cliente registrado correctamente");
		return mensaje;
	}
}
