package com.sinensia.juegos9.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.juegos9.business.model.Videojuego;
import com.sinensia.juegos9.business.services.VideojuegoServices;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {

	@Autowired
	private VideojuegoServices videojuegoServices;
	
	@GetMapping
	public List<Videojuego> getAll(){
		
		return videojuegoServices.getAll();
	}
	
	@GetMapping("/{codigo}")
	public Videojuego getVideojuegoByCodigo(@PathVariable Integer codigo) {
		
		return videojuegoServices.getVideojuegoByCodigo(codigo);
	}
	
	@GetMapping("/codigofabricante/{codigo}")
	public List<Videojuego> getVideojuegoByFabricante(@PathVariable Integer codigo) {
		
		return videojuegoServices.getVideojuegosByFabricante(codigo);
	}
	
	@PostMapping
	public void create(@RequestBody Videojuego videojuego) {
		
		videojuegoServices.create(videojuego);
	}
	
}
