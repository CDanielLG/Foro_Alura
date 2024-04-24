package com.foroalura.springboot.app.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foroalura.springboot.app.apirest.entity.Topico;
import com.foroalura.springboot.app.apirest.service.TopicService;

@RestController
@RequestMapping("/api/topicos")
public class TopicController {

	@Autowired
	private TopicService service;
	
	@GetMapping
	public List<Topico> list(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id) {
		Optional<Topico> topicoOptional = service.finById(id);
		
		if(topicoOptional.isPresent()) {
			return ResponseEntity.ok(topicoOptional.orElseThrow());
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Topico> create(@RequestBody Topico topico){
		Topico topicNew = service.save(topico);
		return ResponseEntity.status(HttpStatus.CREATED).body(topicNew);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Topico> update(@PathVariable Long id, @RequestBody Topico topico){
		
		topico.setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(topico));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Topico topico = new Topico();
		topico.setId(id);
		Optional<Topico> topicoOptional = service.delete(topico);
		
		if(topicoOptional.isPresent()) {
			return ResponseEntity.ok(topicoOptional.orElseThrow());
			
		}
		return ResponseEntity.notFound().build();
	}
	
}
