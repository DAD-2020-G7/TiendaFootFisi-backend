package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.model.ProductoModel;

public interface ProductoServicio {
	public List<ProductoModel> listarProductos();
	public void registrarProducto(ProductoModel oModel);
	public void actualizarProducto(ProductoModel oModel);
	public void actualizarStock(int idProducto, int nCantidad);
}
