package com.sinensia.juegos9.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.juegos9.business.model.Fabricante;
import com.sinensia.juegos9.business.services.FabricanteServices;
import com.sinensia.juegos9.integration.repositories.FabricanteRepository;

@Service
public class FabricanteServicesImpl implements FabricanteServices{
	
	@Autowired
	private FabricanteRepository fabricanteRepository;

	@Override
	public void create(Fabricante fabricante) {
		fabricanteRepository.save(fabricante);
	}

	@Override
	public List<Fabricante> getAll() {
		return fabricanteRepository.findAll();
	}

	@Override
	public Fabricante getFabricanteByCodigo(Integer codigo) {
		
		final Optional<Fabricante> optional = fabricanteRepository.findById(codigo);
		
		return optional.isPresent() ? optional.get() : null;
	}

}
