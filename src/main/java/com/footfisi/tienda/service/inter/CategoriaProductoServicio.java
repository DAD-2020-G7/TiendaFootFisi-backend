package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.model.CategoriaProductoModel;

public interface CategoriaProductoServicio {
	public List<CategoriaProductoModel> listarPorMarca();
	public List<CategoriaProductoModel> listarPorGenero(String sMarca);
	public List<CategoriaProductoModel> listarPorTipo(String sMarca, String sGenero);
}
