package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantCategoria;
import com.footfisi.tienda.model.CategoriaModel;

@Component("categoriaTransform")
public class CategoriaTransform implements Transform<CategoriaModel, MantCategoria>{

	@Override
	public MantCategoria transformME(CategoriaModel oModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public List<MantCategoria> transformME(List<CategoriaModel> lModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public CategoriaModel transformEM(MantCategoria oEntity) {
		if(oEntity != null) {
			CategoriaModel oModelCategoriaProducto = new CategoriaModel();
			oModelCategoriaProducto.setnIdCategoria(oEntity.getIdCategoria());
			oModelCategoriaProducto.setsMarca(oEntity.getVmarca());
			oModelCategoriaProducto.setsGenero(oEntity.getVgenero());
			oModelCategoriaProducto.setsTipo(oEntity.getVtipo());
			
			return oModelCategoriaProducto;
		}
		return null;
	}

	@Override
	public List<CategoriaModel> transformEM(List<MantCategoria> lEntity) {
		if(lEntity != null) {
			List<CategoriaModel> lModelCategoriaProducto = new ArrayList<>();
			
			for(MantCategoria entity : lEntity) {
				lModelCategoriaProducto.add(transformEM(entity));
			}
			
			return lModelCategoriaProducto;
		}
		return null;
	}

}
