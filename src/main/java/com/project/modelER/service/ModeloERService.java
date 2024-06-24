package com.project.modelER.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.ModeloER;

public interface ModeloERService {
	List<ModeloER> findAllModeloER();
	
	ModeloER saveModeloER(ModeloER modeloER,MultipartFile file);

	ModeloER updateModeloER(Long id, ModeloER modeloER);

	void deleteSupuesto(Long id);
}
