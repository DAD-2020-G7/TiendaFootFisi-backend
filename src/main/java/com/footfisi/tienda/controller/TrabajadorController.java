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
import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.TrabajadorModel;
import com.footfisi.tienda.model.UsuarioModel;
import com.footfisi.tienda.service.impl.PersonaServicioImpl;
import com.footfisi.tienda.service.impl.TrabajadorServicioImpl;
import com.footfisi.tienda.service.impl.UsuarioServicioImpl;

@CrossOrigin
@RestController
public class TrabajadorController {
	@Autowired
	@Qualifier("personaService")
	private PersonaServicioImpl personaServicio;
	@Autowired
	@Qualifier("trabajadorService")
	private TrabajadorServicioImpl trabajadorServicio;
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServicioImpl usuarioServicio;
	
	@GetMapping("/api/trabajador/listar")
	public List<TrabajadorModel> listarTrabajadores(){
		return trabajadorServicio.listarTrabajador();
	}
	
	@GetMapping("/api/trabajador/buscar/{sIdTipoDocumento}/{sNumeroDocumento}")
	public TrabajadorModel buscarTrabajador(@PathVariable("sIdTipoDocumento") String sIdTipoDocumento,
			@PathVariable("sNumeroDocumento") String sNumeroDocumento) {
		return trabajadorServicio.buscarTrabajador(sIdTipoDocumento, sNumeroDocumento);
	}
	
	@PostMapping("/api/trabajador/registrar")
	public MensajeForm registrarCliente(@RequestBody UsuarioTrabajadorForm oTrabajadorForm) {
		MensajeForm mensaje = new MensajeForm();
		
		TrabajadorModel oModelTrabajador = trabajadorServicio.buscarTrabajador(oTrabajadorForm.getsIdTipoDocumento(), oTrabajadorForm.getsNumeroDocumento());
		
		if(oModelTrabajador == null) {
			UsuarioModel oModelUsuario = usuarioServicio.buscarUsuario(oTrabajadorForm.getsIdUsuario());
			
			if(oModelUsuario == null) {
				personaServicio.registrarPersonaTrabajador(oTrabajadorForm);
				trabajadorServicio.registrarTrabajador(oTrabajadorForm);
				usuarioServicio.registrarUsuarioTrabajador(oTrabajadorForm);				
				
				mensaje.setsTipo("1");
				mensaje.setsMensaje("Trabajador registrado correctamente");
			}
			else {
				mensaje.setsTipo("0");
				mensaje.setsMensaje("Ya existe el usuario " + oModelUsuario.getsIdUsuario());
			}
			
		}
		else {
			mensaje.setsTipo("0");
			mensaje.setsMensaje("Ya existe un trabajador " + oModelTrabajador.getsApellidoPaterno() + " " + oModelTrabajador.getsApellidoMaterno() + ", " + oModelTrabajador.getsNombres());
		}
		return mensaje;
	}
	
}
