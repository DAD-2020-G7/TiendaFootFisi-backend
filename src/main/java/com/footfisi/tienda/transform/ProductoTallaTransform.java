package com.footfisi.tienda.transform;

import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantProductoTalla;
import com.footfisi.tienda.entity.MantProductoTallaId;
import com.footfisi.tienda.model.ProductoTallaModel;

@Component("productoTallaTransform")
public class ProductoTallaTransform implements Transform<ProductoTallaModel, MantProductoTalla>{

	@Override
	public MantProductoTalla transformME(ProductoTallaModel oModel) {
		if(oModel != null) {
			MantProductoTalla oEntityProductoTalla = new MantProductoTalla();
			
			MantProductoTallaId oEntityProductoTallaId = new MantProductoTallaId();
			oEntityProductoTallaId.setIdProducto(oModel.getIdProducto());
			oEntityProductoTallaId.setIdTalla(oModel.getnIdTalla());
			
			oEntityProductoTalla.setId(oEntityProductoTallaId);

			return oEntityProductoTalla;
		}
		return null;
	}

	@Override
	public List<MantProductoTalla> transformME(List<ProductoTallaModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoTallaModel transformEM(MantProductoTalla oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoTallaModel> transformEM(List<MantProductoTalla> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
