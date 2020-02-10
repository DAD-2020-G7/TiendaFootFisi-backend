package com.footfisi.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footfisi.tienda.model.ProductoModel;
import com.footfisi.tienda.service.impl.ProductoServicioImpl;

@RestController
public class ProductoController {
	@Autowired
	@Qualifier("productoService")
	private ProductoServicioImpl productoServicio;
	
	@GetMapping("/api/producto/listar")
	public List<ProductoModel> listrarProductos(){
		return productoServicio.listarProductos();
	}
	
	@PostMapping("/api/producto/registrar")
	public ResponseEntity<String> registrarProducto(@RequestBody ProductoModel oModel) {
		productoServicio.registrarProducto(oModel);
		return ResponseEntity.ok("Producto registrado correctamente");
	}

	@PostMapping("/api/producto/actualizar")
	public ResponseEntity<String> actualizarProducto(@RequestBody ProductoModel oModel) {
		productoServicio.actualizarProducto(oModel);
		return ResponseEntity.ok("Producto actualizado correctamente");
	}
	
	@PostMapping("/api/producto/stock")
	public ResponseEntity<String> actualizarStock(@RequestBody ProductoModel oModel) {
		//productoServicio.actualizarProducto(oModel);
		return ResponseEntity.ok("Producto actualizado correctamente");
	}
	
}
