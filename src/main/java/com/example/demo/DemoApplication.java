package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domains.Categoria;
import com.example.demo.domains.Cidade;
import com.example.demo.domains.Endereco;
import com.example.demo.domains.Estado;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.EstadoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
		
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria informatica = new Categoria(null, "Informática");
		Categoria escritorio = new Categoria(null, "Escritório");
		categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
		
		Estado sp = new Estado(null, "São Paulo");
		Estado pr = new Estado(null, "Parana");
		Cidade assis = new Cidade(null, "Assis", sp);
		Cidade botucatu = new Cidade(null, "Botucatu", sp);
		Cidade londrina = new Cidade(null, "Londrina", pr);
		Cidade pontaGrossa = new Cidade(null, "Ponta Grossa", pr);
		
		Endereco ruaRodrigues = new Endereco(null, "Rua Rodrigues", "Vila Rodrigues", 64, sp);
		Endereco ruaTeste = new Endereco(null, "Rua Teste", "Vila Teste", 01, pr);
		
		
		
		estadoRepository.saveAll(Arrays.asList(sp, pr));
		cidadeRepository.saveAll(Arrays.asList(assis, botucatu, londrina, pontaGrossa));
		enderecoRepository.saveAll(Arrays.asList(ruaRodrigues, ruaTeste));
		
	}

}
