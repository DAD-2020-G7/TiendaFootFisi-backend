package com.footfisi.tienda.transform;

import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegPersona;
import com.footfisi.tienda.entity.RegPersonaId;
import com.footfisi.tienda.model.PersonaModel;

@Component("personaTransform")
public class PersonaTransform implements Transform<PersonaModel, RegPersona>{

	@Override
	public RegPersona transformME(PersonaModel oModel) {
		if(oModel != null) {
			RegPersonaId oEntityPersonaId = new RegPersonaId();
			oEntityPersonaId.setIdTipoDocumento(oModel.getsIdTipoDocumento());
			oEntityPersonaId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			
			RegPersona oEntityPersona = new RegPersona();
			oEntityPersona.setId(oEntityPersonaId);
			oEntityPersona.setVapellidoPaterno(oModel.getsApellidoPaterno());
			oEntityPersona.setVapellidoMaterno(oModel.getsAapellidoMaterno());
			oEntityPersona.setVnombres(oModel.getsNombres());
			
			return oEntityPersona;
		}
		return null;
	}

	@Override
	public List<RegPersona> transformME(List<PersonaModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaModel transformEM(RegPersona oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaModel> transformEM(List<RegPersona> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
