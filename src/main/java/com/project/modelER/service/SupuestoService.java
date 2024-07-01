package com.project.modelER.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.exception.ServiceException;

public interface SupuestoService {
	List<Supuesto> findAllSupuestos() throws ServiceException;

	Supuesto saveSupuesto(Supuesto supuesto,MultipartFile file)throws ServiceException;

	void deleteSupuesto(Long id)throws ServiceException;

	Supuesto getServicio(Long id)throws ServiceException;

}
