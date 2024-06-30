package com.project.modelER.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.controller.InicioController;
import com.project.modelER.entity.MRelacional;
import com.project.modelER.repository.MRelacionalRepository;

@Service
public class MRelacionalServImplement implements MRelacionalService{
	public static final Logger log = LoggerFactory.getLogger(InicioController.class);
	
	@Autowired
	MRelacionalRepository mRelacionalRepository;

	@Override
	public List<MRelacional> findAllMRelacionales() {
		log.info("findAllMRelacionales");
		
		return mRelacionalRepository.findAll();
	}

	@Override
	public MRelacional saveMRelacional(MRelacional mRelacional, MultipartFile file) {
		log.info("saveMRelacional");
		try {
			mRelacional.setDocument(file.getBytes());
			return mRelacionalRepository.save(mRelacional);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public MRelacional updateMRelacional(Long id, MRelacional mRelacional) {
		log.info("updateMRelacional");
		//if(mRelacional != null);
		return mRelacional;
	}

	@Override
	public void deleteMRelacional(Long id) {
		log.info("deleteMRelacional");
		mRelacionalRepository.deleteById(id);
		
	}

}
