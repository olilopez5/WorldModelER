package com.project.modelER.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.modelER.entity.ModeloER;
import com.project.modelER.repository.ModeloERRepository;



public class ModeloERController {
public static final Logger log = LoggerFactory.getLogger(ModeloERController.class);
	
	
	@Autowired
	ModeloERRepository modeloERRepository;

	@GetMapping("/ModelosER")
	public List<ModeloER> findAllModelosER(){
		log.info("Todos los ModelosER");
		log.debug("otra traza");
		return modeloERRepository.findAll();
		
	}

}
