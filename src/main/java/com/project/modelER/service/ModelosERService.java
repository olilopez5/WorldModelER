package com.project.modelER.service;

import java.util.List;

import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.Supuesto;

public interface ModelosERService {
	List<ModeloER> findAllModelosER();
	
	ModeloER saveModeloER(ModeloER modeloER);

	ModeloER updateModeloER(Long id, ModeloER modeloER);

	void deleteSupuesto(Long id);
}
