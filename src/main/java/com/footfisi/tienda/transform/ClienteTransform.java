package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegCliente;
import com.footfisi.tienda.entity.RegClienteId;
import com.footfisi.tienda.form.UsuarioClienteForm;
import com.footfisi.tienda.model.ClienteModel;

@Component("clienteTransform")
public class ClienteTransform implements Transform<ClienteModel, RegCliente>, TransformForm<ClienteModel, UsuarioClienteForm> {
	
	/**
	 * Hibernate
	 */
	@Override
	public RegCliente transformME(ClienteModel oModel) {
		if(oModel != null) {
			RegClienteId oEntityClienteId = new RegClienteId();
			oEntityClienteId.setIdTipoDocumento(oModel.getsIdTipoDocumento());
			oEntityClienteId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			
			RegCliente oEntityCliente = new RegCliente();
			oEntityCliente.setId(oEntityClienteId);
			oEntityCliente.setVapellidoPaterno(oModel.getsApellidoPaterno());
			oEntityCliente.setVapellidoMaterno(oModel.getsApellidoMaterno());
			oEntityCliente.setVnombres(oModel.getsNombres());
			oEntityCliente.setVdireccion(oModel.getsDireccion());
			oEntityCliente.setVcelular(oModel.getsCelular());
			oEntityCliente.setVcorreoElectronico(oModel.getsCorreoElectronico());
			
			return oEntityCliente;
		}
		return null;
	}

	@Override
	public List<RegCliente> transformME(List<ClienteModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteModel transformEM(RegCliente oEntity) {
		if(oEntity != null) {
			ClienteModel oModelCliente = new ClienteModel();
			
			oModelCliente.setsIdTipoDocumento(oEntity.getId().getIdTipoDocumento());
			oModelCliente.setsNumeroDocumento(oEntity.getId().getVnumeroDocumento());
			oModelCliente.setsNombres(oEntity.getVnombres());
			oModelCliente.setsApellidoPaterno(oEntity.getVapellidoPaterno());
			oModelCliente.setsApellidoMaterno(oEntity.getVapellidoMaterno());
			oModelCliente.setsDireccion(oEntity.getVdireccion());
			oModelCliente.setsCelular(oEntity.getVcelular());
			oModelCliente.setsDireccion(oEntity.getVdireccion());
			
			return oModelCliente;
		}
		return null;
	}

	@Override
	public List<ClienteModel> transformEM(List<RegCliente> lEntity) {
		if(lEntity != null) {
			List<ClienteModel> lModelCliente = new ArrayList<>();
			
			for(RegCliente entity : lEntity) {
				lModelCliente.add(transformEM(entity));
			}
			
			return lModelCliente;
		}
		return null;
	}

	/**
	 * Formulario
	 */
	@Override
	public ClienteModel transformFM(UsuarioClienteForm oForm) {
		if(oForm != null) {
			ClienteModel oModelCliente = new ClienteModel();
			
			oModelCliente.setsIdTipoDocumento(oForm.getsIdTipoDocumento());
			oModelCliente.setsNumeroDocumento(oForm.getsNumeroDocumento());
			oModelCliente.setsApellidoPaterno(oForm.getsApellidoPaterno());
			oModelCliente.setsApellidoMaterno(oForm.getsApellidoMaterno());
			oModelCliente.setsNombres(oForm.getsNombres());
			oModelCliente.setsDireccion(oForm.getsDireccion());
			oModelCliente.setsCelular(oForm.getsCelular());
			oModelCliente.setsCorreoElectronico(oForm.getsCorreoElectronico());
			
			return oModelCliente;
		}
		return null;
	}
}
