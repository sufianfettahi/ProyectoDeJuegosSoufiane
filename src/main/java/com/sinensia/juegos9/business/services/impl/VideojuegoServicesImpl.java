package com.sinensia.juegos9.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.juegos9.business.model.Videojuego;
import com.sinensia.juegos9.business.services.VideojuegoServices;
import com.sinensia.juegos9.integration.repositories.VideojuegoRepository;

@Service
public class VideojuegoServicesImpl implements VideojuegoServices{
	
	@Autowired
	private VideojuegoRepository videojuegoRepository;

	@Override
	public void create(Videojuego videojuego) {
		
		videojuegoRepository.save(videojuego);
	}

	@Override
	public List<Videojuego> getAll() {
		
		return videojuegoRepository.findAll();
	}

	@Override
	public Videojuego getVideojuegoByCodigo(Integer codigo) {

		final Optional<Videojuego> optional = videojuegoRepository.findById(codigo);
		
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public List<Videojuego> getVideojuegosByFabricante(Integer codigo) {
		
		return videojuegoRepository.findByVideojuegosFabricante(codigo);
	}

}
