package com.project.modelER.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.SupuestoService;
import com.project.modelER.service.exception.ServiceException;

@Controller
@RequestMapping("/document")
public class DocumentController {
	public static final Logger log = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	SupuestoService servicio;

	@SuppressWarnings("rawtypes")
	@GetMapping("/pdf/{id}")
	public ResponseEntity ver(Model model, @PathVariable("id") Long id) throws ServiceException {
		log.info("[verPDF]");
		Supuesto supuesto = servicio.getServicio(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));

		byte[] contenidoPDF = supuesto.getDocument();

		return new ResponseEntity<>(contenidoPDF, headers, HttpStatus.OK);

	}

}
