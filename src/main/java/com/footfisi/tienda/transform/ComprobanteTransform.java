package com.footfisi.tienda.transform;

import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegComprobante;
import com.footfisi.tienda.model.ComprobanteModel;

@Component("comprobanteTransform")
public class ComprobanteTransform implements Transform<ComprobanteModel, RegComprobante>	{

	@Override
	public RegComprobante transformME(ComprobanteModel oModel) {
		if(oModel != null) {
			RegComprobante oEntityComprobante = new RegComprobante();
			oEntityComprobante.setVtipoComprobante(oModel.getsTipoComprobante());
			oEntityComprobante.setVestado(oModel.getsEstadoComprobante());
			oEntityComprobante.setDfecha(oModel.getDfechaComprobante());
			
			return oEntityComprobante;
		}
		return null;
	}

	@Override
	public List<RegComprobante> transformME(List<ComprobanteModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComprobanteModel transformEM(RegComprobante oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComprobanteModel> transformEM(List<RegComprobante> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
