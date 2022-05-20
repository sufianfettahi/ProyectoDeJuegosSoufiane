package com.sinensia.juegos9.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.juegos9.business.model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer>{
	
	@Query("SELECT v "
		 + "FROM Videojuego v "
		 + "WHERE v.fabricante.codigo = :codigo")
	List<Videojuego> findByVideojuegosFabricante(Integer codigo);
	
}
