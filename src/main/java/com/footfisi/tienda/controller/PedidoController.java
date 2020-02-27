package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.form.PedidoDetalleForm;
import com.footfisi.tienda.form.PedidoForm;
import com.footfisi.tienda.service.impl.PedidoServicioImpl;
import com.footfisi.tienda.service.impl.ProductoServicioImpl;

@CrossOrigin
@RestController
public class PedidoController {
	@Autowired
	@Qualifier("pedidoService")
	private PedidoServicioImpl pedidoServicio;
	@Autowired
	@Qualifier("productoService")
	private ProductoServicioImpl productoServicio;
	
	@PostMapping("/api/pedido/registrar")
	public MensajeForm registrarProducto(@RequestBody PedidoForm oForm) {
		pedidoServicio.registrarPedido(oForm);
		
		for(PedidoDetalleForm detalle : oForm.getItems()) {
			productoServicio.actualizarStock(Integer.parseInt(detalle.getCodItem()), detalle.getCantidadItem());
		}
		
		MensajeForm mensaje = new MensajeForm();
		mensaje.setsTipo("1");
		mensaje.setsMensaje("Pedido registrado correctamente");
		return mensaje;
	}
}
