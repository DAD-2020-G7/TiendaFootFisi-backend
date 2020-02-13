package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.TallaProductoModel;
import com.footfisi.tienda.service.impl.TallaProductoServicioImpl;

@CrossOrigin
@RestController
public class TallaProductoController {
	@Autowired
	@Qualifier("tallaProductoService")
	private	TallaProductoServicioImpl tallaProductoServicio;
	
	@GetMapping("/api/talla/listar")
	public List<TallaProductoModel> listrarTallas() {
		return tallaProductoServicio.listarTallas();
	}
	
}
