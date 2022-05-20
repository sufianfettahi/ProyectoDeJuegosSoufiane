package com.sinensia.juegos9.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.juegos9.business.model.Fabricante;
import com.sinensia.juegos9.business.model.Tipo;
import com.sinensia.juegos9.business.model.Videojuego;
import com.sinensia.juegos9.business.services.impl.VideojuegoServicesImpl;
import com.sinensia.juegos9.integration.repositories.VideojuegoRepository;

@ExtendWith(MockitoExtension.class)
class VideojuegoServicesTest {
	
	@Mock
	private VideojuegoRepository videojuegoRepository;
	
	@InjectMocks
	private VideojuegoServicesImpl videojuegoServicesImpl;
	
	private Videojuego videojuego1;
	private Videojuego videojuego2;
	private Fabricante fabricante;
	private Tipo tipo;
	
	private List<Videojuego> videojuegosFromRepository;
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	@Test
	void testGetAll() {
		
		when(videojuegoRepository.findAll()).thenReturn(videojuegosFromRepository);
		
		List<Videojuego> videojuegos = videojuegoServicesImpl.getAll();
		
		assertEquals(2, videojuegos.size());
		assertNotNull(videojuegos.get(0));
		
	}
	
	@Test
	void testCreate() {
		
		when(videojuegoRepository.save(videojuego1)).thenReturn(videojuego1);
		
		videojuegoServicesImpl.create(videojuego1);
		
		assertNotNull(videojuego1);
		assertEquals(10, videojuego1.getCodigo());
		assertEquals(Tipo.AVENTURAS, videojuego1.getTipo());
		
	}
	
	@Test
	void testGetVideojuegoByCodigo() {
		
		when(videojuegoRepository.findById(11)).thenReturn(Optional.of(videojuego2));
		
		Videojuego videojuego = videojuegoServicesImpl.getVideojuegoByCodigo(11);
		
		assertNotNull(videojuego);
		assertEquals(11, videojuego.getCodigo());
		assertEquals(90.00, videojuego.getPrecio());
		
	}
	
	@Test
	void testGetVideojuegosByFabricante() {
		
		when(videojuegoRepository.findByVideojuegosFabricante(11)).thenReturn(videojuegosFromRepository);
		
		List<Videojuego> videojuegos = videojuegoServicesImpl.getVideojuegosByFabricante(11);
		
		assertNotNull(videojuegos);
		assertEquals(2, videojuegos.size());
		
	}
	
	@SuppressWarnings("static-access")
	private void initMocks() {
		
		videojuego1 = new Videojuego();
		videojuego2 = new Videojuego();
		fabricante = new Fabricante();
		
		videojuego1.setCodigo(10);
		videojuego1.setDescatalogado(false);
		videojuego1.setFabricante(fabricante);
		videojuego1.setFechaAlta(new Date(1000));
		videojuego1.setPrecio(90.00);
		videojuego1.setTipo(tipo.AVENTURAS);
		videojuego1.setTitulo("GTA");
		
		videojuego2.setCodigo(11);
		videojuego2.setDescatalogado(true);
		videojuego2.setFabricante(fabricante);
		videojuego2.setFechaAlta(new Date(1000));
		videojuego2.setPrecio(90.00);
		videojuego2.setTipo(tipo.FUTBOL);
		videojuego2.setTitulo("PES 2022");
		
		videojuegosFromRepository = new ArrayList<>();
		videojuegosFromRepository.add(videojuego1);
		videojuegosFromRepository.add(videojuego2);
		
	}

}
