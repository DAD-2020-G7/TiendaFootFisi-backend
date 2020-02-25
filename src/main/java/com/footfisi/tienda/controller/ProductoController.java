package com.footfisi.tienda.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.filter.FiltroProducto;
import com.footfisi.tienda.form.MensajeForm;
import com.footfisi.tienda.form.ProductoForm;
import com.footfisi.tienda.model.ProductoModel;
import com.footfisi.tienda.service.impl.ProductoServicioImpl;
import com.footfisi.tienda.service.impl.ProductoTallaServicioImpl;
import com.footfisi.tienda.util.UtilList;

@CrossOrigin
@RestController
public class ProductoController {
	@Autowired
	@Qualifier("productoService")
	private ProductoServicioImpl productoServicio;
	@Autowired
	@Qualifier("productoTallaService")
	private ProductoTallaServicioImpl productoTallaServicio;
	
	@GetMapping("/api/producto/listar")
	public List<ProductoModel> listrarProductos(){
		List<ProductoModel> lProductoModel = productoServicio.listarProductos();
		return lProductoModel;
	}
	
	@PostMapping("/api/producto/listar/filtro")
	public List<ProductoModel> listrarProductosPorCategoria(@RequestBody FiltroProducto filtro){
		List<ProductoModel> lProductoModel = productoServicio.listarProductos();
		
		if(!filtro.getsMarca().equals("")) {
			lProductoModel = lProductoModel.stream().filter(s -> s.getsMarca().equals(filtro.getsMarca()))
					.collect(Collectors.toList());	
		}
		
		if(!filtro.getsGenero().equals("")) {
			lProductoModel = lProductoModel.stream().filter(s -> s.getsGenero().equals(filtro.getsGenero()))
					.collect(Collectors.toList());
		}
		
		if(!filtro.getsTipo().equals("")) {
			lProductoModel = lProductoModel.stream().filter(s -> s.getsTipo().equals(filtro.getsTipo()))
					.collect(Collectors.toList());
		}
		
		if(!filtro.getsNombre().equals("")) {
			lProductoModel = lProductoModel.stream().filter(s -> s.getsNombre().toUpperCase().contains(filtro.getsNombre().toUpperCase()))
					.collect(Collectors.toList());
		}
		
		return lProductoModel;
	}
	
	@PostMapping("/api/producto/registrar")
	public MensajeForm registrarProducto(@RequestBody ProductoForm oForm) {
		productoServicio.registrarProducto(oForm);
		productoTallaServicio.registrarProductoTalla(oForm);
		MensajeForm mensaje = new MensajeForm();
		mensaje.setsTipo("1");
		mensaje.setsMensaje("Producto registrado correctamente");
		return mensaje;
	}

	@PostMapping("/api/producto/actualizar")
	public ResponseEntity<String> actualizarProducto(@RequestBody ProductoForm oForm) {
		productoServicio.actualizarProducto(oForm);
		return ResponseEntity.ok("Producto actualizado correctamente");
	}
	
}
