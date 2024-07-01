package com.project.modelER.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelER.controller.InicioController;
import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.MRelacionalRepository;
import com.project.modelER.repository.ModeloERRepository;

import com.project.modelER.repository.SupuestoRepository;
import com.project.modelER.service.exception.ErrorCode;
import com.project.modelER.service.exception.ErrorMessage;
import com.project.modelER.service.exception.ServiceException;

@Service
public class ComunService implements IComunService {
	public static final Logger log = LoggerFactory.getLogger(ComunService.class);

	@Autowired
	SupuestoRepository supuestosRepository;
	@Autowired
	ModeloERRepository modelosERRepository;
	@Autowired
	MRelacionalRepository mRelacionalRepository;

	@Override
	public List<Supuesto> getSupuestosNivel(Integer level) throws ServiceException {
		log.info("[getSupuestosNivel]");
		log.debug("['level:' + level]");
		List<Supuesto> supuestos = new ArrayList<Supuesto>();
		try {

			supuestos = supuestosRepository.findAllByLevel(level);
			if (level.equals(null))
				throw new ServiceException(ErrorCode.LEVEL_NOT_FOUND);
			
			// Opcion 2. Lambda
			// supuestos = supuestosRepository.findAll().stream().filter(s ->
			// s.getLevel()==1).collect(Collectors.toList());
		} catch (ServiceException se) {
			log.error("Error Interno", se);
			throw se;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL, e);
		}

		return supuestos;

	}

	@Override
	public List<ModeloER> getModelosERNivel(Integer level) throws ServiceException {
		log.info("[getModelosERNivel]");
		log.debug("level:" + level);
		List<ModeloER> modelosER = new ArrayList<ModeloER>();
		try {
			modelosER = modelosERRepository.findAllByLevel(level);
			if (level.equals(null))
				throw new ServiceException(ErrorCode.LEVEL_NOT_FOUND);
			
		} catch (ServiceException se) {
			log.error("Error Interno", se);
			throw se;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL, e);
		}

		return modelosER;

	}

	@Override
	public List<MRelacional> getMRelacionalesNivel(Integer level) throws ServiceException {
		log.info("[getMRelacionalesNivel]");
		log.debug("level:" + level);
		List<MRelacional> mRelacionales = new ArrayList<MRelacional>();
		try {
			mRelacionales = mRelacionalRepository.findAllByLevel(level);
			if (level.equals(null))
				throw new ServiceException(ErrorCode.LEVEL_NOT_FOUND);
		;
		} catch (ServiceException se) {
			log.error("Error Interno", se);
			throw se;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL, e);
		}

		return mRelacionales;
	}

}
