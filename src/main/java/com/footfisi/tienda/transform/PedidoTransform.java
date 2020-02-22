package com.footfisi.tienda.transform;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegCliente;
import com.footfisi.tienda.entity.RegClienteId;
import com.footfisi.tienda.entity.RegPedido;
import com.footfisi.tienda.model.PedidoModel;

@Component("pedidoTransform")
public class PedidoTransform implements Transform<PedidoModel, RegPedido>{

	@Override
	public RegPedido transformME(PedidoModel oModel) {
		if(oModel != null) {
			RegPedido oEntityPedido = new RegPedido();
			
			oEntityPedido.setNprecioTotal(BigDecimal.valueOf(oModel.getnPrecioTotal()));
			oEntityPedido.setDfechaCompra(oModel.getdFechaCompra());
			oEntityPedido.setVestado(oModel.getsEstado());
			
			RegCliente oEntityCliente = new RegCliente();
			RegClienteId oEntityClienteId = new RegClienteId();
			oEntityClienteId.setIdTipoDocumento(oModel.getsIdTipoDocumento());
			oEntityClienteId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			oEntityCliente.setId(oEntityClienteId);
			
			oEntityPedido.setRegCliente(oEntityCliente);
			
			return oEntityPedido;
		}
		return null;
	}

	@Override
	public List<RegPedido> transformME(List<PedidoModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoModel transformEM(RegPedido oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoModel> transformEM(List<RegPedido> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
