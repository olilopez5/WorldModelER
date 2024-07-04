package com.project.modelER.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.repository.MRelacionalRepository;
import com.project.modelER.service.exception.ErrorCode;
import com.project.modelER.service.exception.ServiceException;

@Service
public class MRelacionalServImplement implements MRelacionalService {
	public static final Logger log = LoggerFactory.getLogger(MRelacionalServImplement.class);

	@Autowired
	MRelacionalRepository mRelacionalRepository;

	@Override
	public List<MRelacional> findAllMRelacionales() throws ServiceException {
		log.info("[findAllMRelacionales]");
		log.debug("[findAllMRelacionales: " + "]");

		List<MRelacional> mRelacionales;

		try {
			mRelacionales = mRelacionalRepository.findAll();

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}

		return mRelacionales;

	}

	@Override
	public MRelacional saveMRelacional(MRelacional mRelacional, MultipartFile file) throws ServiceException {
		log.info("[saveMRelacional]");
		log.debug("[saveMRelacional: " + mRelacional + "]");
		try {
			mRelacional.setNameDocument(file.getName());
			mRelacional.setContentType(file.getContentType());
			mRelacional.setDocument(file.getBytes());

			return mRelacionalRepository.save(mRelacional);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.MODELO_RELACION_NOT_FOUND);
		}

		return null;
	}

	@Override
	public void deleteMRelacional(Long id) throws ServiceException {
		log.info("[deleteMRelacional]");
		log.debug("[deleteSupuesto: " + id + "]");

		try {
			mRelacionalRepository.deleteById(id);

		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.MODELO_RELACION_NOT_FOUND);

		}
	}

	@Override
	public MRelacional getMRelacional(Long id) throws ServiceException {
		log.info("[getMRelacional]");
		log.debug("[getMRelacional: " + id + "]");
		try {
			Optional<MRelacional> opMRelacional = mRelacionalRepository.findById(id);
			if (!opMRelacional.isPresent()) {
				throw new ServiceException(ErrorCode.MODELO_RELACION_NOT_FOUND);
			}
			MRelacional mRelacional= opMRelacional.get();
			log.debug("[mRelacional: " + mRelacional.toString() + "]");
			return mRelacional;

		} catch (ServiceException se) {
			log.error("ServiceException", se);
			throw se;
		}catch (Exception e) {
			log.error("Exception", e);
			throw new ServiceException(ErrorCode.ERROR_GENERAL);
		}
	}
}
