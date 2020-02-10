package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.TipoDocumentoModel;
import com.footfisi.tienda.service.impl.TipoDocumentoServicioImpl;

@RestController
public class TipoDocumentoController {
	@Autowired
	@Qualifier("tipoDocumentoService")
	private TipoDocumentoServicioImpl tipoDocumentoServicio;
	
	@GetMapping("/api/tipodocumento/listar")
	public List<TipoDocumentoModel> listrarTipoDocumentos(){
		return tipoDocumentoServicio.listarTipoDocumentos();
	}
	
}
