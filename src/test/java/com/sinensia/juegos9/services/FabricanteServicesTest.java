package com.sinensia.juegos9.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
import com.sinensia.juegos9.business.services.impl.FabricanteServicesImpl;
import com.sinensia.juegos9.integration.repositories.FabricanteRepository;

@ExtendWith(MockitoExtension.class)
class FabricanteServicesTest {
	
	@Mock
	private FabricanteRepository fabricanteRepository;
	
	@InjectMocks
	private FabricanteServicesImpl fabricanteServicesImpl;
	
	private Fabricante fabricante1;
	private Fabricante fabricante2;
	
	private List<Fabricante> fabricantesFromRepository;
	
	@BeforeEach
	public void init() {
		initMocks();
	}
	
	@Test
	void testGetAll() {
		
		when(fabricanteRepository.findAll()).thenReturn(fabricantesFromRepository);
		
		List<Fabricante> fabricantes = fabricanteServicesImpl.getAll();
		
		assertEquals(2, fabricantes.size());
		assertNotNull(fabricantes.get(0));
		
	}
	
	@Test
	void testCreate() {
		
		when(fabricanteRepository.save(fabricante1)).thenReturn(fabricante1);
		
		fabricanteServicesImpl.create(fabricante1);
		
		assertNotNull(fabricante1);
		assertEquals(1 , fabricante1.getCodigo());
		assertEquals("EPIC", fabricante1.getNombre());
		
	}
	
	@Test
	void testGetFabricanteByCodigo() {
		
		when(fabricanteRepository.findById(2)).thenReturn(Optional.of(fabricante2));
		
		Fabricante fabricante = fabricanteServicesImpl.getFabricanteByCodigo(2);
		
		assertNotNull(fabricante);
		assertEquals(2, fabricante.getCodigo());
		assertEquals("EA", fabricante.getNombre());
		
	}
	
	private void initMocks() {
		
		fabricante1 = new Fabricante();
		fabricante2 = new Fabricante();
		
		fabricante1.setCodigo(1);
		fabricante1.setNombre("EPIC");
		
		fabricante2.setCodigo(2);
		fabricante2.setNombre("EA");
		
		fabricantesFromRepository = new ArrayList<>();
		fabricantesFromRepository.add(fabricante1);
		fabricantesFromRepository.add(fabricante2);
		
	}

}
