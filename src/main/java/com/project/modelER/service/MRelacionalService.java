

	package com.project.modelER.service;

	import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.MRelacional;



	public interface MRelacionalService {
	
	List<MRelacional> findAllMRelacionales();
		
	MRelacional saveMRelacional(MRelacional mRelacional,MultipartFile file);

	MRelacional updateMRelacional(Long id, MRelacional mRelacional);

		void deleteMRelacional(Long id);
	}

