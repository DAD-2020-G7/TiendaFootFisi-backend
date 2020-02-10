package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantProductoTalla;
import com.footfisi.tienda.model.TallaProductoModel;

@Component("tallaProductoTransform")
public class TallaProductoTransform implements Transform<TallaProductoModel, MantProductoTalla>{

	@Override
	public MantProductoTalla transformME(TallaProductoModel oModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public List<MantProductoTalla> transformME(List<TallaProductoModel> lModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public TallaProductoModel transformEM(MantProductoTalla oEntity) {
		if(oEntity != null) {
			TallaProductoModel oModelTallaProducto = new TallaProductoModel();
			
			oModelTallaProducto.setnIdTalla(oEntity.getIdTalla());
			oModelTallaProducto.setsDescripcion(oEntity.getVdescripcion());
			
			return oModelTallaProducto;
		}
		return null;
	}

	@Override
	public List<TallaProductoModel> transformEM(List<MantProductoTalla> lEntity) {
		if(lEntity != null) {
			List<TallaProductoModel> lModelTallaProducto = new ArrayList<>();
			
			for(MantProductoTalla entity : lEntity) {
				lModelTallaProducto.add(transformEM(entity));
			}
			
			return lModelTallaProducto;
		}
		return null;
	}

}
