package com.footfisi.tienda.transform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footfisi.tienda.form.PedidoDetalleForm;
import com.footfisi.tienda.form.PedidoForm;
import com.footfisi.tienda.model.ComprobanteModel;
import com.footfisi.tienda.model.PedidoDetalleModel;
import com.footfisi.tienda.model.PedidoModel;

@Component("pedidoFormTransform")
public class PedidoFormTransform implements TransformForm<PedidoModel, PedidoForm>{

	@Override
	public PedidoModel transformFM(PedidoForm oForm) {
		if(oForm != null) {
			PedidoModel oModelPedido = new PedidoModel();
			oModelPedido.setsIdTipoDocumento(String.valueOf(oForm.getTipoDoc()));
			oModelPedido.setsNumeroDocumento(oForm.getNumeroDoc());
			
			oModelPedido.setnPrecioTotal(oForm.getTotal());
			oModelPedido.setdFechaCompra(oForm.getFechaRegistro());
			oModelPedido.setdFechaPago(oForm.getFechaRegistro());
			
			ComprobanteModel oModelComprobante = new ComprobanteModel();
			oModelComprobante.setsTipoComprobante(oForm.getTipoComp()==1?"Factura":"Boleta");
			oModelComprobante.setsEstadoComprobante("Pagado");
			oModelComprobante.setDfechaComprobante(new Date());
			
			oModelPedido.setoComprobanteModel(oModelComprobante);
			
			List<PedidoDetalleModel> lModelPedidoDetalle = new ArrayList<>();
			
			for(PedidoDetalleForm detalle : oForm.getItems()) {
				PedidoDetalleModel oModelDetalle = new PedidoDetalleModel();
				
				oModelDetalle.setnIdProducto(Integer.parseInt(detalle.getCodItem()));
				oModelDetalle.setnCantidadProducto(detalle.getCantidadItem());
				oModelDetalle.setsNombreProducto(detalle.getDescripcionItem());
				oModelDetalle.setnTotalParcial(detalle.getPrecioItem() * detalle.getCantidadItem());
				
				lModelPedidoDetalle.add(oModelDetalle);
			}
			
			oModelPedido.setlDetallePedido(lModelPedidoDetalle);
			oModelPedido.setsEstado("Pagado");
			
			return oModelPedido;
		}
		return null;
	}
	
}
