package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.dto.GrupoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.GrupoStatusEnum;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.response.Response;
import com.github.dsaouda.fiap.spring.secretfriends.validator.SimpleValidation;

@Transactional
@Service
public class GrupoService {

	private Logger logger = LoggerFactory.getLogger(GrupoService.class);
	
	@Autowired
	private GrupoRepository repository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public List<GrupoDTO> getAll(Usuario usuario) {
		Iterable<Grupo> grupos = repository.findByAdministrador(usuario);
		return GrupoDTO.toDTO(grupos);
	}
	
	public ResponseEntity<?> criar(Grupo grupo, Usuario usuario) {
		grupo.setAdministrador(usuario);
		
		SimpleValidation<Grupo> validation = new SimpleValidation<>(grupo);
		if (validation.isValid()) {
			grupo = repository.save(grupo);
			participanteRepository.save(new Participante(usuario, grupo));
			return Response.created(grupo).build();
		}
		
		return Response.badRequest(validation.getErrors()).build();
	}
	
	public void realizarSorteio(Date dataSorteio) {
		Stream<Grupo> sorteios = repository.streamPrecisaSortear(dataSorteio);
		sorteios.forEach(g -> {
			List<Participante> participantes = participanteRepository.findByGrupo(g);
			
			if (participantes.size() <= 1) {
				logger.info("sorteio falhou por falta de participante");
				g.setStatus(GrupoStatusEnum.SORTEIO_FALHA);
				repository.save(g);
				return ;
			}
			
			logger.info("realizando sorteio grupo {}", g.getNome());
			Collections.shuffle(participantes);
			
			for(int i = 0; i < participantes.size(); i++) {
				Participante amigoSecreto = getAmigoSecretoPorPosicao(participantes, i);
				Participante participante = participantes.get(i);
				participante.setAmigoSecreto(amigoSecreto.getParticipante());
				
				participanteRepository.save(participante);
			}
			
			g.setStatus(GrupoStatusEnum.SORTEIO_SUCESSO);
			repository.save(g);
		});
	}
	
	private Participante getAmigoSecretoPorPosicao(List<Participante> participantes, int i) {
		Participante amigoSecreto = participantes.get(i == 0 ? participantes.size()-1 : i-1);
		return amigoSecreto;
	}
}
