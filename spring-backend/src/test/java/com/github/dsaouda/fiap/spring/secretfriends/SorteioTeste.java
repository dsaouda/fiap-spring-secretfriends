package com.github.dsaouda.fiap.spring.secretfriends;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
@Transactional
public class SorteioTeste {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Test
	public void sorteio() throws Exception {
		
	}

	
}
