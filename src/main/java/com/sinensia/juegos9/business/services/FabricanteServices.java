package com.sinensia.juegos9.business.services;

import java.util.List;

import com.sinensia.juegos9.business.model.Fabricante;

public interface FabricanteServices {
	
	void create(Fabricante fabricante);
	
	List<Fabricante> getAll();
	
	Fabricante getFabricanteByCodigo(Integer codigo);

}
