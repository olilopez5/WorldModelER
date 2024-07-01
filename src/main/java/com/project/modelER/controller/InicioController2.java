package com.project.modelER.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.IComunService;
import com.project.modelER.service.exception.ServiceException;

@Controller
@RequestMapping("/inicio")
public class InicioController2 {
	public static final Logger log = LoggerFactory.getLogger(InicioController2.class);
	
	@Autowired
	IComunService servicio;
	
	@GetMapping
	public String inicio(Model model) throws ServiceException {
		log.info("[inicio]");
		
		List<Supuesto> supuestosNivel1 = servicio.getSupuestosNivel(1);
		model.addAttribute("supuestosNivel1", supuestosNivel1);
		List<Supuesto> supuestosNivel2 = servicio.getSupuestosNivel(2);
		model.addAttribute("supuestosNivel2", supuestosNivel2);
		List<Supuesto> supuestosNivel3 = servicio.getSupuestosNivel(3);
		model.addAttribute("supuestosNivel3", supuestosNivel3);
				
		
		
		
		List<ModeloER> modelosERNivel1 = servicio.getModelosERNivel(1);
		model.addAttribute("modelosERNivel1", modelosERNivel1);
		List<ModeloER> modelosERNivel2 = servicio.getModelosERNivel(2);
		model.addAttribute("modelosERNivel2", modelosERNivel2);
		List<ModeloER> modelosERNivel3 = servicio.getModelosERNivel(3);
		model.addAttribute("modelosERNivel3", modelosERNivel3);
		
		List<MRelacional> modelosRNivel1 = servicio.getMRelacionalesNivel(1);
		model.addAttribute("modelosRNivel1", modelosRNivel1);
		List<MRelacional> modelosRNivel2 = servicio.getMRelacionalesNivel(2);
		model.addAttribute("modelosRNivel2", modelosRNivel2);
		List<MRelacional> modelosRNivel3 = servicio.getMRelacionalesNivel(3);
		model.addAttribute("modelosRNivel2", modelosRNivel3);
		return "inicio";
		
	}

}
