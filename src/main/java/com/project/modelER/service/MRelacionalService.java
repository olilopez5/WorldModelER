
package com.project.modelER.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.MRelacional;
import com.project.modelER.service.exception.ServiceException;

public interface MRelacionalService {

	List<MRelacional> findAllMRelacionales() throws ServiceException;

	MRelacional saveMRelacional(MRelacional mRelacional, MultipartFile file) throws ServiceException;

	void deleteMRelacional(Long id) throws ServiceException;
	
	//MRelacional getImage(Long id)throws ServiceException;
}
