package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.PersonaModel;

@Component("personaUsuarioClienteTransform")
public class PersonaUsuarioClienteTransform implements TransformForm<PersonaModel, UsuarioClienteForm>{

	@Override
	public PersonaModel transformFM(UsuarioClienteForm oForm) {
		if(oForm != null) {
			PersonaModel oModelPersona = new PersonaModel();
			
			oModelPersona.setsIdTipoDocumento(oForm.getsIdTipoDocumento());
			oModelPersona.setsNumeroDocumento(oForm.getsNumeroDocumento());
			oModelPersona.setsApellidoPaterno(oForm.getsApellidoPaterno());
			oModelPersona.setsApellidoMaterno(oForm.getsApellidoMaterno());
			oModelPersona.setsNombres(oForm.getsNombres());
			
			return oModelPersona;
		}
		return null;
	}

}
