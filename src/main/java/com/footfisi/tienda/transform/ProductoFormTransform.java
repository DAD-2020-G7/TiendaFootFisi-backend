package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoModel;

@Component("productoFormTransform")
public class ProductoFormTransform implements TransformForm<ProductoModel, ProductoForm>{

	@Override
	public ProductoModel transformFM(ProductoForm oForm) {
		if(oForm != null) {
			ProductoModel oModelProducto = new ProductoModel();
			oModelProducto.setIdProducto(oForm.getIdProducto());
			
			oModelProducto.setIdCategoria(oForm.getIdCategoria());
			oModelProducto.setsMarca(oForm.getsMarca());
			oModelProducto.setsGenero(oForm.getsGenero());
			oModelProducto.setsTipo(oForm.getsTipo());
			
			oModelProducto.setsNombre(oForm.getsNombre());
			oModelProducto.setsDescripcion(oForm.getsDescripcion());
			oModelProducto.setnPrecioUnitario(oForm.getnPrecioUnitario());
			oModelProducto.setnCantidad(oForm.getnCantidad());
			oModelProducto.setsFoto(oForm.getsFoto());
			
			return oModelProducto;
		}
		return null;
	}

}
