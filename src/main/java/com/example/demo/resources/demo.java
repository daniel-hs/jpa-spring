package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos")
public class demo {

	List<String> mensagens = new ArrayList<>();
	
	@GetMapping
	public List<String> getMensagens() {
		return this.mensagens;
	}
	
	@PostMapping
	public List<String> postMensagem(@RequestBody String msg) {
		String auxMsg = msg.trim();
		System.out.println(auxMsg);
		mensagens.add(auxMsg);
		return mensagens;
	}
	
	@DeleteMapping(value = "/{msg}")
	public List<String> deleteMensagem(@PathVariable String msg) {
		System.out.println("aqui " + msg);
		
		for(int i = 0; i < mensagens.size(); i ++ ) {
			if (mensagens.get(i) == msg) {
				mensagens.remove(i);
				System.out.println("Achou: " + mensagens.get(i));
			}
		}
		
		System.out.println(mensagens);
		return null;
	}
	
	
	
	

}
