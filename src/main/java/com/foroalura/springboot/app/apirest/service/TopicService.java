package com.foroalura.springboot.app.apirest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.foroalura.springboot.app.apirest.entity.Topico;

public interface TopicService {

	List<Topico> findAll();
	
	Optional<Topico> finById(Long id);
	
	Topico save(Topico topic);
	
	Optional<Topico>  delete(Topico topic);

}
