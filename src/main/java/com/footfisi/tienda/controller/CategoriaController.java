package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.CategoriaModel;
import com.footfisi.tienda.service.impl.CategoriaServicioImpl;

@CrossOrigin
@RestController
public class CategoriaController {
	@Autowired
	@Qualifier("categoriaService")
	private CategoriaServicioImpl categoriaProductoServicio;

	@GetMapping("/api/categoria/listar/marca")
	public List<CategoriaModel> listrarCategoriaPorMarca() {
		return categoriaProductoServicio.listarPorMarca();
	}

	@GetMapping("/api/categoria/listar/genero/{sMarca}")
	public List<CategoriaModel> listrarCategoriaPorGenero(@PathVariable("sMarca") String sMarca) {
		return categoriaProductoServicio.listarPorGenero(sMarca);
	}

	@GetMapping("/api/categoria/listar/tipo/{sMarca}/{sGenero}")
	public List<CategoriaModel> listrarCategoriaPorGenero(@PathVariable("sMarca") String sMarca,
			@PathVariable("sGenero") String sGenero) {
		return categoriaProductoServicio.listarPorTipo(sMarca, sGenero);
	}
}
