package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantProductoCategoria;
import com.footfisi.tienda.model.CategoriaProductoModel;

@Component("categoriaProductoTransform")
public class CategoriaProductoTransform implements Transform<CategoriaProductoModel, MantProductoCategoria>{

	@Override
	public MantProductoCategoria transformME(CategoriaProductoModel oModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public List<MantProductoCategoria> transformME(List<CategoriaProductoModel> lModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public CategoriaProductoModel transformEM(MantProductoCategoria oEntity) {
		if(oEntity != null) {
			CategoriaProductoModel oModelCategoriaProducto = new CategoriaProductoModel();
			oModelCategoriaProducto.setnIdCategoria(oEntity.getIdCategoria());
			oModelCategoriaProducto.setsMarca(oEntity.getVmarca());
			oModelCategoriaProducto.setsGenero(oEntity.getVgenero());
			oModelCategoriaProducto.setsTipo(oEntity.getVtipo());
			
			return oModelCategoriaProducto;
		}
		return null;
	}

	@Override
	public List<CategoriaProductoModel> transformEM(List<MantProductoCategoria> lEntity) {
		if(lEntity != null) {
			List<CategoriaProductoModel> lModelCategoriaProducto = new ArrayList<>();
			
			for(MantProductoCategoria entity : lEntity) {
				lModelCategoriaProducto.add(transformEM(entity));
			}
			
			return lModelCategoriaProducto;
		}
		return null;
	}

}
