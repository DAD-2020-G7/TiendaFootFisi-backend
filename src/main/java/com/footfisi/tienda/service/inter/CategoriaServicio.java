package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.model.CategoriaModel;

public interface CategoriaServicio {
	public List<CategoriaModel> listarPorMarca();
	public List<CategoriaModel> listarPorGenero(String sMarca);
	public List<CategoriaModel> listarPorTipo(String sMarca, String sGenero);
}
