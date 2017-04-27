package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.dto.GrupoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	GrupoRepository repository;
	
	public List<GrupoDTO> getAll() {
		Iterable<Grupo> grupos = repository.findAll();
		return GrupoDTO.toDTO(grupos);
	}
}
