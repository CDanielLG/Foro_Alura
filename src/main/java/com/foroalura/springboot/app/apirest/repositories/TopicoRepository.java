package com.foroalura.springboot.app.apirest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.foroalura.springboot.app.apirest.entity.Topico;

public interface TopicoRepository extends CrudRepository<Topico, Long> {

}
