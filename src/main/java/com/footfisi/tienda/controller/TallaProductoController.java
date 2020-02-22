package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.TallaModel;
import com.footfisi.tienda.service.impl.TallaServicioImpl;

@CrossOrigin
@RestController
public class TallaProductoController {
	@Autowired
	@Qualifier("tallaService")
	private	TallaServicioImpl tallaProductoServicio;
	
	@GetMapping("/api/talla/listar")
	public List<TallaModel> listrarTallas() {
		return tallaProductoServicio.listarTallas();
	}
	
}
