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

import com.footfisi.tienda.filter.FiltroCategoria;
import com.footfisi.tienda.model.ProductoModel;
import com.footfisi.tienda.service.impl.ProductoServicioImpl;
import com.footfisi.tienda.util.UtilList;

@CrossOrigin
@RestController
public class ProductoController {
	@Autowired
	@Qualifier("productoService")
	private ProductoServicioImpl productoServicio;
	
	@GetMapping("/api/producto/listar")
	public List<ProductoModel> listrarProductos(){
		List<ProductoModel> lProductoModel = productoServicio.listarProductos();
		lProductoModel = lProductoModel.stream().filter(UtilList.distinctByKey(s -> s.getIdCategoria()))
				.collect(Collectors.toList());
		return lProductoModel;
	}
	
	@PostMapping("/api/producto/listar/filtro")
	public List<ProductoModel> listrarProductosPorCategoria(@RequestBody FiltroCategoria filtro){
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
		
		if(!filtro.getsTalla().equals("")) {
			lProductoModel = lProductoModel.stream().filter(s -> s.getsTalla().equals(filtro.getsTalla()))
					.collect(Collectors.toList());
		}
		
		return lProductoModel;
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
