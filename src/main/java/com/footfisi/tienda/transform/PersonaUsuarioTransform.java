package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.PersonaModel;

@Component("personaUsuarioTransform")
public class PersonaUsuarioTransform implements TransformForm<PersonaModel, UsuarioClienteForm>{

	@Override
	public PersonaModel transformFM(UsuarioClienteForm oForm) {
		if(oForm != null) {
			PersonaModel oModelPersona = new PersonaModel();
			
			oModelPersona.setsIdTipoDocumento(oForm.getsIdTipoDocumento());
			oModelPersona.setsNumeroDocumento(oForm.getsNumeroDocumento());
			oModelPersona.setsApellidoPaterno(oForm.getsApellidoPaterno());
			oModelPersona.setsAapellidoMaterno(oForm.getsAapellidoMaterno());
			oModelPersona.setsNombres(oForm.getsNombres());
			
			return oModelPersona;
		}
		return null;
	}

}
