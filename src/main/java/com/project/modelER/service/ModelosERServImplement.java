package com.project.modelER.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.ModeloERRepository;

@Service
public class ModelosERServImplement implements ModelosERService {

	@Autowired

	ModeloERRepository modeloERRepository;

	@Override
	public List<ModeloER> findAllModelosER() {

		return modeloERRepository.findAll();
		
	}

	@Override
	public ModeloER saveModeloER(ModeloER modeloER) {
		return modeloERRepository.save(modeloER);
	}

	@Override
	public ModeloER updateModeloER(Long id, ModeloER modeloER) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSupuesto(Long id) {
		modeloERRepository.deleteById(id);
		
	}


}
