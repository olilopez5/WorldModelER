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

import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.MRelacionalService;
import com.project.modelER.service.ModeloERService;
import com.project.modelER.service.SupuestoService;
import com.project.modelER.service.exception.ServiceException;

@Controller
@RequestMapping("/crear")
public class CrearController {
	public static final Logger log = LoggerFactory.getLogger(CrearController.class);

	@Autowired
	SupuestoService supuestoService;

	@GetMapping("/supuesto")
	public String toCreateSupuesto() {
		log.info("[toCreateSupuesto]");
		return "createSupuesto";

	}

	@PostMapping("/supuesto")
	public String crearSupuesto(Supuesto supuesto, @RequestParam("file") MultipartFile file) {
		log.info("[crearSupuesto]");

		try {
			supuestoService.saveSupuesto(supuesto, file);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return "redirect:/level/" + supuesto.getLevel();

	}

	@Autowired
	ModeloERService modeloERService;

	@GetMapping("/modeloER")
	public String toCreateModeloER() {
		log.info("[toCreateModeloER]");
		return "createModeloER";

	}

	@PostMapping("/modeloER")
	public String crearModeloER(ModeloER modeloER, @RequestParam("file") MultipartFile file) {
		log.info("[crearModeloER]");

		try {
			
			modeloERService.saveModeloER(modeloER, file);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/level/" + modeloER.getLevel();

	}

	@Autowired
	MRelacionalService mRelacionalService;

	@GetMapping("/modeloRelacional")
	public String toCreateMRelacional() {
		log.info("[toCreateMRelacional]");
		return "createMRelacional";
	}

	@PostMapping("/modeloRelacional")
	public String toCreateMRelacional(MRelacional mRelacional, @RequestParam("file") MultipartFile file) {
		log.info("[crearModeloRelacional]");
		try {
			mRelacionalService.saveMRelacional(mRelacional, file);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/level/" + mRelacional.getLevel();

	}
	

	
	
}

