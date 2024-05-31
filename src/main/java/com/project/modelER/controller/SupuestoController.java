package com.project.modelER.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.SupuestoService;

@RestController

public class SupuestoController  {
	public static final Logger log = LoggerFactory.getLogger(SupuestoController.class);
	
	
	@Autowired
	SupuestoService supuestoService;

	@GetMapping("/supuestos")
	public List<Supuesto> findAllSupuestos(){
		log.info("findAllSupuestos");
		log.debug("otra traza");
		return supuestoService.findAllSupuestos();
		
	}
	
	
}
