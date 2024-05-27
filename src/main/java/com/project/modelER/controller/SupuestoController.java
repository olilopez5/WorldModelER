package com.project.modelER.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.SupuestoService;

@RestController
public class SupuestoController  {
	
	
	@Autowired
	SupuestoService supuestoService;

	@GetMapping("/supuestos")
	public List<Supuesto> findAllSupuestos(){
		return supuestoService.findAllSupuestos();
		
	}
	
	
}
