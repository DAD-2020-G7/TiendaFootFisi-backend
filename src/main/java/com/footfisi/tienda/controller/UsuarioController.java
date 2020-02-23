package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.ClienteModel;
import com.footfisi.tienda.model.UsuarioModel;
import com.footfisi.tienda.service.impl.ClienteServicioImpl;
import com.footfisi.tienda.service.impl.UsuarioServicioImpl;

@CrossOrigin
@RestController
public class UsuarioController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServicioImpl usuarioServicio;
	@Autowired
	@Qualifier("clienteService")
	private ClienteServicioImpl clienteServicio;
	
	@GetMapping("/api/login/usuario/cliente/{sIdUsuario}")
	public ClienteModel buscarClienteUsuario(@PathVariable("sIdUsuario") String sIdUsuario) {
		UsuarioModel oModelUsuario = usuarioServicio.buscarUsuario(sIdUsuario);
		
		if (oModelUsuario != null) {
			return clienteServicio.buscarCliente(oModelUsuario.getsIdTipoDocumento(), oModelUsuario.getsNumeroDocumento());
		}
		else {
			return null;
		}
	}
}
