package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegPersona;
import com.footfisi.tienda.entity.RegPersonaId;
import com.footfisi.tienda.entity.SegUsuario;
import com.footfisi.tienda.model.UsuarioModel;

@Component("usuarioTransform")
public class UsuarioTransform implements Transform<UsuarioModel, SegUsuario>{

	@Override
	public SegUsuario transformME(UsuarioModel oModel) {
		if(oModel != null) {
			RegPersonaId oEntityPersonaId = new RegPersonaId();
			oEntityPersonaId.setIdTipoDocumento(oModel.getsIdTipoDocumento());
			oEntityPersonaId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			
			RegPersona oEntityPersona = new RegPersona();
			oEntityPersona.setId(oEntityPersonaId);
			
			SegUsuario oEntityUsuario = new SegUsuario();
			oEntityUsuario.setIdUsuario(oModel.getsIdUsuario());
			oEntityUsuario.setVcontrasenia(oModel.getsContrasenia());
			oEntityUsuario.setRegPersona(oEntityPersona);
			
			return oEntityUsuario;
		}
		return null;
	}

	@Override
	public List<SegUsuario> transformME(List<UsuarioModel> lModel) {
		if(lModel != null) {
			List<SegUsuario> lEntityUsuario = new ArrayList<>();
			
			for(UsuarioModel model : lModel) {
				lEntityUsuario.add(transformME(model));
			}
			
			return lEntityUsuario;
		}
		return null;
	}

	@Override
	public UsuarioModel transformEM(SegUsuario oEntity) {
		if(oEntity != null) {
			UsuarioModel oModelUsuario = new UsuarioModel();
			oModelUsuario.setsIdUsuario(oEntity.getIdUsuario());
			oModelUsuario.setsContrasenia(oEntity.getVcontrasenia());
			
			oModelUsuario.setsIdTipoDocumento(oEntity.getRegPersona().getId().getIdTipoDocumento());
			oModelUsuario.setsNumeroDocumento(oEntity.getRegPersona().getId().getVnumeroDocumento());
			
			return oModelUsuario;
		}
		return null;
	}

	@Override
	public List<UsuarioModel> transformEM(List<SegUsuario> lEntity) {
		if(lEntity != null) {
			List<UsuarioModel> lModelUsuario = new ArrayList<>();
			
			for(SegUsuario entity : lEntity) {
				lModelUsuario.add(transformEM(entity));
			}
			
			return lModelUsuario;
		}
		return null;
	}

}
