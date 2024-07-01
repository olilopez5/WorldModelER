package com.project.modelER.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.IComunService;
import com.project.modelER.service.exception.ServiceException;

@Controller
@RequestMapping("/level")
public class InicioController {
	public static final Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@Autowired
	IComunService servicio;
	
	@GetMapping("/{level}")
	public String inicio(Model model,@PathVariable("level")Integer level) throws ServiceException {
		log.info("[inicio]");
		
		model.addAttribute("title",getMessageLevel(level));
		
		List<Supuesto> supuestos = servicio.getSupuestosNivel(level);
		model.addAttribute("supuestos", supuestos);
				
		List<ModeloER> modelosER = servicio.getModelosERNivel(level);
		model.addAttribute("modelosER", modelosER);
		
		List<MRelacional> mRelacionales = servicio.getMRelacionalesNivel(level);
		model.addAttribute("mRelacionales", mRelacionales);
		return "level";
		
	}

	private String getMessageLevel(Integer level) {
	     switch(level){
	    	 case 1:
	    		 return "title.level.easy";
	    	 case 2:
	    		 return "title.level.medium";
	    	 case 3:
	    		 return "title.level.hard";

	     }	
	     return null;
	}

	
	
}
