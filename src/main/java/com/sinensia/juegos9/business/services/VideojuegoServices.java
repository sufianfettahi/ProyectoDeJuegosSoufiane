package com.sinensia.juegos9.business.services;

import java.util.List;

import com.sinensia.juegos9.business.model.Videojuego;

public interface VideojuegoServices {
	
	void create(Videojuego videojuego);
	
	List<Videojuego> getAll();
	
	Videojuego getVideojuegoByCodigo(Integer codigo);
	
	List<Videojuego> getVideojuegosByFabricante(Integer codigo);
	
}
