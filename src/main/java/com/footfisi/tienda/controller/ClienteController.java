package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.ClienteModel;
import com.footfisi.tienda.model.UsuarioModel;
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
		
	@GetMapping("/api/cliente/listar")
	public List<ClienteModel> listrarClientes(){
		return clienteServicio.listarCliente();
	}
	
	@GetMapping("/api/cliente/buscar/{sIdTipoDocumento}/{sNumeroDocumento}")
	public ClienteModel buscarCliente(@PathVariable("sIdTipoDocumento") String sIdTipoDocumento,
			@PathVariable("sNumeroDocumento") String sNumeroDocumento) {
		return clienteServicio.buscarCliente(sIdTipoDocumento, sNumeroDocumento);
	}
	
	@PostMapping("/api/cliente/registrar")
	public MensajeForm registrarCliente(@RequestBody UsuarioClienteForm oClienteForm) {
		MensajeForm mensaje = new MensajeForm();
		
		ClienteModel oModelCliente = clienteServicio.buscarCliente(oClienteForm.getsIdTipoDocumento(), oClienteForm.getsNumeroDocumento());
		
		if(oModelCliente == null) {
			UsuarioModel oModelUsuario = usuarioServicio.buscarUsuario(oClienteForm.getsIdUsuario());
			
			if(oModelUsuario == null) {
				personaServicio.registrarPersonaCliente(oClienteForm);
				clienteServicio.registrarCliente(oClienteForm);
				usuarioServicio.registrarUsuarioCliente(oClienteForm);
				
				mensaje.setsTipo("1");
				mensaje.setsMensaje("Cliente registrado correctamente");
			}
			else {
				mensaje.setsTipo("0");
				mensaje.setsMensaje("Ya existe el usuario " + oModelUsuario.getsIdUsuario());
			}
			
		}
		else {
			mensaje.setsTipo("0");
			mensaje.setsMensaje("Ya existe un cliente " + oModelCliente.getsApellidoPaterno() + " " + oModelCliente.getsApellidoMaterno() + ", " + oModelCliente.getsNombres());
		}
		return mensaje;
	}
	
}
