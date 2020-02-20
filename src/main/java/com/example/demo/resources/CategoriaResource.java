package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		
		List<Categoria> categorias = repository.findByOrderByNome();
		
		return new ResponseEntity<>(categorias, HttpStatus.OK);
		
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<Categoria> findByNome(@PathVariable String nome) {
		
		Categoria categoria = repository.findByNome(nome);
		
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}

}
