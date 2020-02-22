package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantTalla;
import com.footfisi.tienda.model.TallaModel;

@Component("tallaTransform")
public class TallaTransform implements Transform<TallaModel, MantTalla>{

	@Override
	public MantTalla transformME(TallaModel oModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public List<MantTalla> transformME(List<TallaModel> lModel) {
		/**
		 * Por el momento no se usa
		 */
		return null;
	}

	@Override
	public TallaModel transformEM(MantTalla oEntity) {
		if(oEntity != null) {
			TallaModel oModelTallaProducto = new TallaModel();
			
			oModelTallaProducto.setnIdTalla(oEntity.getIdTalla());
			oModelTallaProducto.setsDescripcion(oEntity.getVdescripcion());
			
			return oModelTallaProducto;
		}
		return null;
	}

	@Override
	public List<TallaModel> transformEM(List<MantTalla> lEntity) {
		if(lEntity != null) {
			List<TallaModel> lModelTallaProducto = new ArrayList<>();
			
			for(MantTalla entity : lEntity) {
				lModelTallaProducto.add(transformEM(entity));
			}
			
			return lModelTallaProducto;
		}
		return null;
	}

}
