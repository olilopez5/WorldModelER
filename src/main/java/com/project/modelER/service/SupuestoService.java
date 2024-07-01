package com.project.modelER.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;

public interface SupuestoService {
	List<Supuesto> findAllSupuestos();

	Supuesto saveSupuesto(Supuesto supuesto,MultipartFile file);

	Supuesto updateSupuesto(Long id, Supuesto supuesto);

	void deleteSupuesto(Long id);

	Supuesto getServicio(Long id);

}
