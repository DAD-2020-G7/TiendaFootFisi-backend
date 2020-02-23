package com.footfisi.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoTallaModel;
import com.footfisi.tienda.repository.RepositoryProductoTalla;
import com.footfisi.tienda.service.inter.ProductoTallaServicio;
import com.footfisi.tienda.transform.ProductoTallaFormTransform;
import com.footfisi.tienda.transform.ProductoTallaTransform;

@Service("productoTallaService")
public class ProductoTallaServicioImpl implements ProductoTallaServicio{
	@Autowired
	@Qualifier("productoTallaRepository")
	private RepositoryProductoTalla productoTallaRepository;
	@Autowired
	@Qualifier("productoTallaFormTransform")
	private ProductoTallaFormTransform productoTallaFormTransform;
	@Autowired
	@Qualifier("productoTallaTransform")
	private ProductoTallaTransform productoFormTransform;
	
	@Override
	public void registrarProductoTalla(ProductoForm oForm) {
		List<ProductoTallaModel> lModel = productoTallaFormTransform.transformFM(oForm); 

		for(ProductoTallaModel oModel : lModel) {
			productoTallaRepository.save(productoFormTransform.transformME(oModel));
		}
	}

}
