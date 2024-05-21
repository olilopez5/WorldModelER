package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Supuesto;
import com.example.demo.service.SupuestoService;

@RestController
public class SupuestoController  {
	
	
	@Autowired
	SupuestoService supuestoService;

	@GetMapping("/findAllSupuestos")
	public List<Supuesto> findAllSupuestos(){
		return supuestoService.findAllSupuestos();
		
	}
	
	
}
