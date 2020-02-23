package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.model.ClienteModel;
import com.footfisi.tienda.model.UsuarioModel;
import com.footfisi.tienda.service.impl.ClienteServicioImpl;
import com.footfisi.tienda.service.impl.UsuarioServicioImpl;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServicioImpl usuarioServicio;
	@Autowired
	@Qualifier("clienteService")
	private ClienteServicioImpl clienteServicio;

	@GetMapping("/api/login/usuario/{sIdUsuario}/{sContrasenia}")
	public MensajeForm buscarCliente(@PathVariable("sIdUsuario") String sIdUsuario,
			@PathVariable("sContrasenia") String sContrasenia) {

		MensajeForm mensaje = new MensajeForm();

		UsuarioModel oModelUsuario = usuarioServicio.buscarUsuario(sIdUsuario);

		if (oModelUsuario != null) {
			if (oModelUsuario.getsContrasenia().equals(sContrasenia)) {
				ClienteModel oModelCliente = clienteServicio.buscarCliente(oModelUsuario.getsIdTipoDocumento(), oModelUsuario.getsNumeroDocumento());
				if(oModelCliente != null) {
					mensaje.setsTipo("3");
					mensaje.setsMensaje("Usuario registrado - cliente.");
				}
			} else {
				mensaje.setsTipo("4");
				mensaje.setsMensaje("La contraseña no coincide.");
			}
		} else {
			mensaje.setsTipo("5");
			mensaje.setsMensaje("No existe usuario.");
		}

		return mensaje;
	}

}
