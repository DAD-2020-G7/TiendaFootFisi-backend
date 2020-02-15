package com.footfisi.tienda.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {
	
	@GetMapping("/")
	public String Home() {
		return "Bienvenido a la API REST de la Tienda Foot Fisi";
	}
	
}
