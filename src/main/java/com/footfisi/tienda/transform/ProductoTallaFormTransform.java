package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.form.ProductoTallaForm;
import com.footfisi.tienda.model.ProductoTallaModel;

@Component("productoTallaFormTransform")
public class ProductoTallaFormTransform implements TransformForm<List<ProductoTallaModel>, ProductoForm>{

	@Override
	public List<ProductoTallaModel> transformFM(ProductoForm oForm) {
		if(oForm != null) {
			List<ProductoTallaModel> lModelProductoTalla = new ArrayList<>();
			
			for(ProductoTallaForm form : oForm.getlTallas()) {
				ProductoTallaModel oModelProductoTalla = new ProductoTallaModel();
				
				oModelProductoTalla.setIdProducto(oForm.getIdProducto());
				oModelProductoTalla.setnIdTalla(form.getnIdTalla());
				
				lModelProductoTalla.add(oModelProductoTalla);
			}
			
			return lModelProductoTalla;
		}
		return null;
	}

}
