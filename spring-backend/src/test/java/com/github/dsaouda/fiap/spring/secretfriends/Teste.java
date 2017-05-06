package com.github.dsaouda.fiap.spring.secretfriends;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class Teste {
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@Autowired
	private ConviteRepository conviteRepo;
	
	@Test
    public void abc() throws Exception {	
		Grupo grupo = grupoRepo.findByUuid("ab864126-827d-4e76-9b09-adf4c3853ff6");
		
		System.out.println("\ngrupo: " + grupo);
		System.out.println("\ngrupo id: " + grupo.getId());
		System.out.println("\ngrupo uuid: " + grupo.getUuid());
		System.out.println("\nadm: " + grupo.getAdministrador());
		
		Convite convite = conviteRepo.findOne(1L);
		System.out.println("convite: " + convite);
		System.out.println("convite uuid: " + convite.getUuid());
		System.out.println("convite grupo: " + convite.getGrupo());
		System.out.println("convite grupo uuid: " + convite.getGrupo().getUuid());
		System.out.println("convite grupo id: " + convite.getGrupo().getId());
		System.out.println("convite grupo nome: " + convite.getGrupo().getNome());
		
		System.out.println();
		System.out.println("convite de: " + convite.getDe());
		System.out.println("convite de id: " + convite.getDe().getId());
		System.out.println("convite de uuid: " + convite.getDe().getUuid());
		System.out.println("convite de nome: " + convite.getDe().getNome());
				
		System.out.println();
		System.out.println("convite para: " + convite.getPara());
		System.out.println("convite para id: " + convite.getPara().getId());
		System.out.println("convite para uuid: " + convite.getPara().getUuid());
		System.out.println("convite para nome: " + convite.getPara().getNome());
    }
}
