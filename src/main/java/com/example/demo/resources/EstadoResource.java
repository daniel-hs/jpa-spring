package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Cidade;
import com.example.demo.domains.Estado;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoResource {


	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping("/cidades")
	public ResponseEntity<List<Cidade>> findCidades() {
		
		List<Cidade> cidades = cidadeRepository.findAll();
		
		return new ResponseEntity<>(cidades, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Estado>> findEstados() {
		
		List<Estado> estados = estadoRepository.findAll();
		
		return new ResponseEntity<>(estados, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Estado>> deleteEstadoECidades(@PathVariable Long id) {
		
		estadoRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}