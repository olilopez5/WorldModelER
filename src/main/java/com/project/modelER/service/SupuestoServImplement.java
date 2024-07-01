package com.project.modelER.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.SupuestoRepository;
import com.project.modelER.service.exception.ErrorCode;
import com.project.modelER.service.exception.ServiceException;

@Service
public class SupuestoServImplement implements SupuestoService {
	public static final Logger log = LoggerFactory.getLogger(SupuestoServImplement.class);

	@Autowired
	SupuestoRepository supuestoRepository;

	@Override
	public List<Supuesto> findAllSupuestos() throws ServiceException {
		log.info("[findAllSupuestos]");
		log.debug("[findAllSupuestos: " + "]");

		List<Supuesto> supuestos;

		try {
			supuestos = supuestoRepository.findAll();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

		return supuestos;

	}

	@Override
	public Supuesto saveSupuesto(Supuesto supuesto, MultipartFile file) throws ServiceException {
		log.info("[saveSupuesto]");
		log.debug("[saveSupuesto: " + supuesto + "]");
		try {
			supuesto.setDocument(file.getBytes());
			return supuestoRepository.save(supuesto);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

		return null;
	}

	@Override
	public void deleteSupuesto(Long id) throws ServiceException {
		log.info("[deleteSupuesto]");
		log.debug("[deleteSupuesto: " + id + "]");

		try {
			supuestoRepository.deleteById(id);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.SUPUESTO_NOT_FOUND);

		}
	}

	
	@Override
	public Supuesto getServicio(Long id) throws ServiceException {
		log.info("[getServicio]");
		log.debug("[getServicio: " + id + "]");
		try {
			Optional<Supuesto> opSupuesto = supuestoRepository.findById(id);
			if (!opSupuesto.isPresent()) {
				throw new ServiceException(ErrorCode.SUPUESTO_NOT_FOUND);
			}
			return opSupuesto.get();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

	}
}
