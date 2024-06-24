package com.project.modelER.service;

import java.util.List;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.entity.Supuesto;
import com.project.modelER.service.exception.ServiceException;

public interface IComunService {

	List<Supuesto> getSupuestosNivel(Integer level) throws ServiceException;
	List<ModeloER> getModelosERNivel(Integer level) throws ServiceException;
	List<MRelacional> getMRelacionalesNivel(Integer level) throws ServiceException;

}