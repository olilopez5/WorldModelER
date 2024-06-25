package com.project.modelER.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.repository.MRelacionalRepository;

@Service
public class MRelacionalServImplement implements MRelacionalService{
	
	@Autowired
	MRelacionalRepository mRelacionalRepository;

	@Override
	public List<MRelacional> findAllMRelacionales() {
		
		return mRelacionalRepository.findAll();
	}

	@Override
	public MRelacional saveMRelacional(MRelacional mRelacional, MultipartFile file) {
		
		return mRelacionalRepository.save(mRelacional);
	}

	@Override
	public MRelacional updateMRelacional(Long id, MRelacional mRelacional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMRelacional(Long id) {
		mRelacionalRepository.deleteById(id);
		
	}

}
