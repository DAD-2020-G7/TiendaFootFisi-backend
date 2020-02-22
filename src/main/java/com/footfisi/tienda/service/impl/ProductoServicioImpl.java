package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.entity.MantProducto;
import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoModel;
import com.footfisi.tienda.repository.RepositoryProducto;
import com.footfisi.tienda.service.inter.ProductoServicio;
import com.footfisi.tienda.transform.ProductoFormTransform;
import com.footfisi.tienda.transform.ProductoTransform;

@Service("productoService")
public class ProductoServicioImpl implements ProductoServicio{
	@Autowired
	@Qualifier("productoRepository")
	private RepositoryProducto productoRepository;
	@Autowired
	@Qualifier("productoTransform")
	private ProductoTransform productoTransform;
	@Autowired
	@Qualifier("productoFormTransform")
	private ProductoFormTransform productoFormTransform;
	
	@Override
	public List<ProductoModel> listarProductos() {
		return productoTransform.transformEM(productoRepository.findAll());
	}

	@Override
	public void registrarProducto(ProductoForm oForm) {
		oForm.setIdProducto((int)(productoRepository.count()) + 1);
		
		ProductoModel oModel = productoFormTransform.transformFM(oForm);
		
		productoRepository.save(productoTransform.transformME(oModel));
	}

	@Override
	public void actualizarProducto(ProductoModel oModel) {
		productoRepository.save(productoTransform.transformME(oModel));
	}

	@Override
	public void actualizarStock(int idProducto, int nCantidad) {
		MantProducto oEntityProducto = productoRepository.findByIdProducto(idProducto);
		
		oEntityProducto.setNcantidad(oEntityProducto.getNcantidad() - nCantidad);
		productoRepository.save(oEntityProducto);
	}

}
