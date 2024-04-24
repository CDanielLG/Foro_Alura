package com.foroalura.springboot.app.apirest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foroalura.springboot.app.apirest.entity.Topico;
import com.foroalura.springboot.app.apirest.repositories.TopicoRepository;

@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicoRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Topico> findAll() {
		
		return (List<Topico>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Topico> finById(Long id) {
	
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Topico save(Topico topic) {
		
	return repository.save(topic);
	}

	@Override
	@Transactional
	public Optional<Topico> delete(Topico topic) {
		Optional<Topico> topicOptional = repository.findById(topic.getId());
		topicOptional.ifPresent(topicDb -> {
			repository.delete(topicDb);
		});
		return topicOptional;
	}
	  public void guardarFecha() {
	        Topico topico = new Topico();
	        topico.setFecha_creacion(new Date());
	        repository.save(topico);
	    }

	

}
