package com.sinensia.juegos9.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.juegos9.business.model.Fabricante;
import com.sinensia.juegos9.business.services.FabricanteServices;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteServices fabricanteServices;
	
	@GetMapping
	public List<Fabricante> getAll(){
		
		return fabricanteServices.getAll();
	}
	
	@GetMapping("/{codigo}")
	public Fabricante getFabricanteByCodigo(@PathVariable Integer codigo) {
		
		return fabricanteServices.getFabricanteByCodigo(codigo);
	}
	
	@PostMapping
	public void create(@RequestBody Fabricante fabricante) {
		
		fabricanteServices.create(fabricante);
	}
	
}
