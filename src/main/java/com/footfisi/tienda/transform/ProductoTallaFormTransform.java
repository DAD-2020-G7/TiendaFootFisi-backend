package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoTallaModel;

@Component("productoTallaFormTransform")
public class ProductoTallaFormTransform implements TransformForm<ProductoTallaModel, ProductoForm>{

	@Override
	public ProductoTallaModel transformFM(ProductoForm oForm) {
		if(oForm != null) {
			ProductoTallaModel oModelProductoTalla = new ProductoTallaModel();
			
			oModelProductoTalla.setIdProducto(oForm.getIdProducto());
			oModelProductoTalla.setnIdTalla(oForm.getIdTalla());
			
			return oModelProductoTalla;
		}
		return null;
	}

}
