package com.project.modelER.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.SupuestoService;

@Controller
@RequestMapping("/crear")
public class CrearController  {
	public static final Logger log = LoggerFactory.getLogger(CrearController.class);
	
	
	@Autowired
	SupuestoService supuestoService;

	@GetMapping("/supuesto")
	public String aCrearSupuesto(){
		log.info("aCrearSupuesto");
		return "creacion";
		
	}
	
	
	@PostMapping("/supuesto")
	public String crearSupuesto(Supuesto supuesto,@RequestParam("file") MultipartFile file ){
		log.info("crearSupuesto");
		
		supuestoService.saveSupuesto(supuesto, file);
		
		return "redirect:/n/"+supuesto.getLevel();
		
	}
	
	
}
