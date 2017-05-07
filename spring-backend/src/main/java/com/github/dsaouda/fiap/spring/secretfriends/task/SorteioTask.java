package com.github.dsaouda.fiap.spring.secretfriends.task;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.dsaouda.fiap.spring.secretfriends.service.GrupoService;

@Component
public class SorteioTask {

	private Logger logger = LoggerFactory.getLogger(SorteioTask.class);
	
	@Autowired
	private GrupoService service;
	
	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
		Date dataSorteio = new Date();
		logger.info("verificando se precisa realizar sorteio em {}", dataSorteio);
        
		service.realizarSorteio(dataSorteio);
    }
	
}
