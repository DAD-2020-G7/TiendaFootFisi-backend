package com.footfisi.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.footfisi.tienda.entity.RegComprobante;
import com.footfisi.tienda.entity.RegPedido;
import com.footfisi.tienda.entity.RegPedidoProducto;
import com.footfisi.tienda.form.PedidoForm;
import com.footfisi.tienda.model.PedidoDetalleModel;
import com.footfisi.tienda.model.PedidoModel;
import com.footfisi.tienda.repository.RepositoryComprobante;
import com.footfisi.tienda.repository.RepositoryPedido;
import com.footfisi.tienda.repository.RepositoryPedidoProducto;
import com.footfisi.tienda.service.inter.PedidoServicio;
import com.footfisi.tienda.transform.ComprobanteTransform;
import com.footfisi.tienda.transform.PedidoDetalleTransform;
import com.footfisi.tienda.transform.PedidoFormTransform;
import com.footfisi.tienda.transform.PedidoTransform;

@Service("pedidoService")
public class PedidoServicioImpl implements PedidoServicio{
	@Autowired
	@Qualifier("pedidoRepository")
	private RepositoryPedido pedidoRepository;
	@Autowired
	@Qualifier("pedidoProductoRepository")
	private RepositoryPedidoProducto pedidoProductoRepository;
	@Autowired
	@Qualifier("comprobanteRepository")
	private RepositoryComprobante comprobanteRepository;
	@Autowired
	@Qualifier("pedidoTransform")
	private PedidoTransform pedidoTransform;
	@Autowired
	@Qualifier("pedidoDetalleTransform")
	private PedidoDetalleTransform pedidoDetalleTransform;
	@Autowired
	@Qualifier("pedidoFormTransform")
	private PedidoFormTransform pedidoFormTransform;
	@Autowired
	@Qualifier("comprobanteTransform")
	private ComprobanteTransform comprobanteTransform;
	
	@Override
	public void registrarPedido(PedidoForm oForm) {
		PedidoModel oModelPedido = pedidoFormTransform.transformFM(oForm);
		
		RegComprobante oEntityComprobante = comprobanteTransform.transformME(oModelPedido.getoComprobanteModel());
		oEntityComprobante.setIdComprobante((int)comprobanteRepository.count()+1);
		
		comprobanteRepository.save(oEntityComprobante);
		
		RegPedido oEntityPedido = pedidoTransform.transformME(oModelPedido);
		oEntityPedido.setIdPedido((int)pedidoRepository.count()+1);
		oEntityPedido.setRegComprobante(oEntityComprobante);
		
		pedidoRepository.save(oEntityPedido);
		
		for(PedidoDetalleModel model : oModelPedido.getlDetallePedido()) {
			RegPedidoProducto oEntityPedidoProducto = pedidoDetalleTransform.transformME(model);
			oEntityPedidoProducto.getId().setIdPedido(oEntityPedido.getIdPedido());
			
			pedidoProductoRepository.save(oEntityPedidoProducto);
		}
	}

}
