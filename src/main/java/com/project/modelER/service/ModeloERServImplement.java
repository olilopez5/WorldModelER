package com.project.modelER.service;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.repository.ModeloERRepository;
import com.project.modelER.service.exception.ErrorCode;
import com.project.modelER.service.exception.ServiceException;

@Service
public class ModeloERServImplement implements ModeloERService {
	public static final Logger log = LoggerFactory.getLogger(ModeloERServImplement.class);

	@Autowired

	ModeloERRepository modeloERRepository;

	@Override
	public List<ModeloER> findAllModeloER() throws ServiceException {
		log.info("[findAllModeloER]");
		log.debug("[findAllModeloER: " + "]");

		List<ModeloER> modelosER;

		try {
			modelosER = modeloERRepository.findAll();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

		return modelosER;

	}

	@Override
	public ModeloER saveModeloER(ModeloER modeloER, MultipartFile file) throws ServiceException {
		log.info("[saveMRelacional]");
		log.debug("[saveMRelacional: " + modeloER + "]");
		try {
			modeloER.setDocument(file.getBytes());
			return modeloERRepository.save(modeloER);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.MODELO_ER_NOT_FOUND);
		}

		return null;
	}

	@Override
	public void deleteModeloER(Long id) throws ServiceException {
		log.info("[deleteModeloER]");
		log.debug("[deleteModeloER: " + id + "]");

		try {
			modeloERRepository.deleteById(id);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.MODELO_ER_NOT_FOUND);

		}
	}

}
