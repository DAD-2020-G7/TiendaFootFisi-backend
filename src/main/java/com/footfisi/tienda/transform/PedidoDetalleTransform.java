package com.footfisi.tienda.transform;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.entity.RegPedidoProducto;
import com.footfisi.tienda.entity.RegPedidoProductoId;
import com.footfisi.tienda.model.PedidoDetalleModel;

@Component("pedidoDetalleTransform")
public class PedidoDetalleTransform implements Transform<PedidoDetalleModel, RegPedidoProducto>{

	@Override
	public RegPedidoProducto transformME(PedidoDetalleModel oModel) {
		if(oModel != null) {
			RegPedidoProducto oEntityPedidoProducto = new RegPedidoProducto();
			
			RegPedidoProductoId oEntityPedidoProductoId = new RegPedidoProductoId();
			oEntityPedidoProductoId.setIdProducto(oModel.getnIdProducto());
			
			oEntityPedidoProducto.setId(oEntityPedidoProductoId);
			oEntityPedidoProducto.setNcantidad(oModel.getnCantidadProducto());
			oEntityPedidoProducto.setNsubTotal(BigDecimal.valueOf(oModel.getnTotalParcial()));
			oEntityPedidoProducto.setNidTalla(oModel.getnIdTalla());
			
			return oEntityPedidoProducto;
		}
		return null;
	}

	@Override
	public List<RegPedidoProducto> transformME(List<PedidoDetalleModel> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDetalleModel transformEM(RegPedidoProducto oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDetalleModel> transformEM(List<RegPedidoProducto> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
