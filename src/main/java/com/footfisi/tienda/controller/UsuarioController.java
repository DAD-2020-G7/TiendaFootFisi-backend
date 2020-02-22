package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.service.impl.UsuarioServicioImpl;

@CrossOrigin
@RestController
public class UsuarioController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServicioImpl usuarioServicio;
}
