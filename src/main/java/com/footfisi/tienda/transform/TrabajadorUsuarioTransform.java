package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.UsuarioTrabajadorForm;
import com.footfisi.tienda.model.UsuarioModel;

@Component("trabajadorUsuarioTransform")
public class TrabajadorUsuarioTransform implements TransformForm<UsuarioModel, UsuarioTrabajadorForm>{

	@Override
	public UsuarioModel transformFM(UsuarioTrabajadorForm oForm) {
		if(oForm != null) {
			UsuarioModel oModelUsuario = new UsuarioModel();
			
			oModelUsuario.setsIdUsuario(oForm.getsIdUsuario());
			oModelUsuario.setsContrasenia(oForm.getsContrasenia());
			oModelUsuario.setsIdTipoDocumento(oForm.getsIdTipoDocumento());
			oModelUsuario.setsNumeroDocumento(oForm.getsNumeroDocumento());
			
			return oModelUsuario;
		}
		return null;
	}

}
