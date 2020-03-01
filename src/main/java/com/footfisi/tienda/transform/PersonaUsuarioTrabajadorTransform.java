package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.PersonaModel;

@Component("personaUsuarioTrabajadorTransform")
public class PersonaUsuarioTrabajadorTransform implements TransformForm<PersonaModel, UsuarioTrabajadorForm>{

	@Override
	public PersonaModel transformFM(UsuarioTrabajadorForm oForm) {
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
