package com.footfisi.tienda.transform;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.UsuarioModel;

@Component("clienteUsuarioTransform")
public class ClienteUsuarioTransform implements TransformForm<UsuarioModel, UsuarioClienteForm>{

	@Override
	public UsuarioModel transformFM(UsuarioClienteForm oForm) {
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
