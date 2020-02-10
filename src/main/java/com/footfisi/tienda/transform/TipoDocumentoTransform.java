package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.MantTipoDocumento;
import com.footfisi.tienda.model.TipoDocumentoModel;

@Component("tipoDocumentoTransform")
public class TipoDocumentoTransform implements Transform<TipoDocumentoModel, MantTipoDocumento>{

	@Override
	public MantTipoDocumento transformME(TipoDocumentoModel oModel) {
		if(oModel != null) {
			/**
			 * Por el momento no se usa
			 */
		}
		return null;
	}

	@Override
	public List<MantTipoDocumento> transformME(List<TipoDocumentoModel> lModel) {
		if(lModel != null) {
			/**
			 * Por el momento no se usa
			 */
		}
		return null;
	}

	@Override
	public TipoDocumentoModel transformEM(MantTipoDocumento oEntity) {
		if(oEntity != null) {
			TipoDocumentoModel oModelTipoDocumento = new TipoDocumentoModel();
			oModelTipoDocumento.setsIdTipoDocumento(oEntity.getIdTipoDocumento());
			oModelTipoDocumento.setsDescripcionLarga(oEntity.getVdescripcionLarga());
			oModelTipoDocumento.setsDescripcionCorta(oEntity.getVdescripcionCorta());
			
			return oModelTipoDocumento;
		}
		return null;
	}

	@Override
	public List<TipoDocumentoModel> transformEM(List<MantTipoDocumento> lEntity) {
		if(lEntity != null) {
			List<TipoDocumentoModel> lModelTipoDocumento = new ArrayList<>();
			
			for(MantTipoDocumento entity : lEntity) {
				lModelTipoDocumento.add(transformEM(entity));
			}
			
			return lModelTipoDocumento;
		}
		return null;
	}

}
