package com.project.modelER.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelER.controller.InicioController;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.ModeloRelacional;
import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.ModeloERRepository;
import com.project.modelER.repository.ModeloRRepository;
import com.project.modelER.repository.SupuestoRepository;
import com.project.modelER.service.exception.ServiceException;

@Service
public class ComunService implements IComunService {
	public static final Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@Autowired
	SupuestoRepository supuestosRepository;
	@Autowired	
	ModeloERRepository modelosERRepository;
	@Autowired
	ModeloRRepository modelosRRepository;

	@Override
	public List<Supuesto> getSupuestosNivel(Integer level) throws ServiceException{
		log.info("getSupuestosNivel");
		log.debug("level:"+level);
		List<Supuesto> supuestos = new ArrayList<Supuesto>();
		try {
			supuestos = supuestosRepository.findAllByLevel(level);
			//Opcion 2. Lambda
			//supuestos = supuestosRepository.findAll().stream().filter(s -> s.getLevel()==1).collect(Collectors.toList());
		}catch(Exception e) {
			log.error("Error general",e);
			throw new ServiceException();
		}
		
		return supuestos;
		
	}
	
	@Override
	public List<ModeloER> getModelosERNivel(Integer level) throws ServiceException{
		log.info("getModelosERNivel");
		log.debug("level:"+level);
		List<ModeloER> modelosER = new ArrayList<ModeloER>();
		try {
			modelosER = modelosERRepository.findAllByLevel(level);
			//Opcion 2. Lambda
			// modelosER = modelosERRepository.findAll().stream().filter(s -> s.getLevel()==1).collect(Collectors.toList());
		}catch(Exception e) {
			log.error("Error general",e);
			throw new ServiceException();
		}
		
		return modelosER;
		
	}
	

	@Override
	public List<ModeloRelacional> getModelosRNivel(Integer level) throws ServiceException{
		
		log.info("getModelosRNivel");
		log.debug("level:"+level);
		List<ModeloRelacional> modelosR = new ArrayList<ModeloRelacional>();
		try {
			modelosR = modelosRRepository.findAllByLevel(level);
			//Opcion 2. Lambda
			// modelosR = modelosRRepository.findAll().stream().filter(s -> s.getLevel()==1).collect(Collectors.toList());
		}catch(Exception e) {
			log.error("Error general",e);
			throw new ServiceException();
		}
		
		return modelosR;
		
	}

	
	
	
	
	
	
	
}
