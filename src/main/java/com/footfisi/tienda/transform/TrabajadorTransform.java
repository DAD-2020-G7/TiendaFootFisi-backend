package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegTrabajador;
import com.footfisi.tienda.entity.RegTrabajadorId;
import com.footfisi.tienda.model.TrabajadorModel;

@Component("trabajadorTransform")
public class TrabajadorTransform implements Transform<TrabajadorModel, RegTrabajador>{

	@Override
	public RegTrabajador transformME(TrabajadorModel oModel) {
		if(oModel != null) {
			RegTrabajadorId oEntityTrabajadorId = new RegTrabajadorId();
			oEntityTrabajadorId.setIdTipoDocumento(oModel.getsIdTipoDocumento());
			oEntityTrabajadorId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			
			RegTrabajador oEntityTrabajador = new RegTrabajador();
			oEntityTrabajador.setId(oEntityTrabajadorId);
			oEntityTrabajador.setVapellidoPaterno(oModel.getsApellidoPaterno());
			oEntityTrabajador.setVapellidoMaterno(oModel.getsAapellidoMaterno());
			oEntityTrabajador.setVnombres(oModel.getsNombres());
			oEntityTrabajador.setVtipoTrabajador(oModel.getsTipoTrabajador());
			
			return oEntityTrabajador;
		}
		return null;
	}

	@Override
	public List<RegTrabajador> transformME(List<TrabajadorModel> lModel) {
		if(lModel != null) {
			List<RegTrabajador> lEntityTrabajador = new ArrayList<>();
			
			for(TrabajadorModel model : lModel) {
				lEntityTrabajador.add(transformME(model));
			}
			
			return lEntityTrabajador;
		}
		return null;
	}

	@Override
	public TrabajadorModel transformEM(RegTrabajador oEntity) {
		if(oEntity != null) {
			TrabajadorModel oModelTrabajador = new TrabajadorModel();
			
			oModelTrabajador.setsIdTipoDocumento(oEntity.getId().getIdTipoDocumento());
			oModelTrabajador.setsNumeroDocumento(oEntity.getId().getVnumeroDocumento());
			oModelTrabajador.setsApellidoPaterno(oEntity.getVapellidoPaterno());
			oModelTrabajador.setsAapellidoMaterno(oEntity.getVapellidoMaterno());
			oModelTrabajador.setsNombres(oEntity.getVnombres());
			oModelTrabajador.setsTipoTrabajador(oEntity.getVtipoTrabajador());
			
			return oModelTrabajador;
		}
		return null;
	}

	@Override
	public List<TrabajadorModel> transformEM(List<RegTrabajador> lEntity) {
		if(lEntity != null) {
			List<TrabajadorModel> lModelTrabajador = new ArrayList<>();
			
			for(RegTrabajador entity : lEntity) {
				lModelTrabajador.add(transformEM(entity));
			}
			
			return lModelTrabajador;
		}
		return null;
	}

}
