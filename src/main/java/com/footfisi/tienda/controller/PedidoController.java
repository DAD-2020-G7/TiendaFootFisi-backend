package com.footfisi.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.form.PedidoForm;
import com.footfisi.tienda.service.impl.PedidoServicioImpl;

@CrossOrigin
@RestController
public class PedidoController {
	@Autowired
	@Qualifier("pedidoService")
	private PedidoServicioImpl pedidoServicio;
	
	@PostMapping("/api/pedido/registrar")
	public MensajeForm registrarProducto(@RequestBody PedidoForm oForm) {
		pedidoServicio.registrarPedido(oForm);
		
		MensajeForm mensaje = new MensajeForm();
		mensaje.setsTipo("1");
		mensaje.setsMensaje("Pedido registrado correctamente");
		return mensaje;
	}
}
