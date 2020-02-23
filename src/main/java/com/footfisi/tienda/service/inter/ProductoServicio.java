package com.footfisi.tienda.service.inter;

import java.util.List;

import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoModel;

public interface ProductoServicio {
	public List<ProductoModel> listarProductos();
	public void registrarProducto(ProductoForm oForm);
	public void actualizarProducto(ProductoForm oForm);
	public void actualizarStock(int idProducto, int nCantidad);
}
