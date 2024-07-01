package com.project.modelER.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.project.modelER.entity.ModeloER;
import com.project.modelER.service.exception.ServiceException;

public interface ModeloERService {
	List<ModeloER> findAllModeloER() throws ServiceException;

	ModeloER saveModeloER(ModeloER modeloER, MultipartFile file) throws ServiceException;

	void deleteModeloER(Long id) throws ServiceException;

	// ModeloER getImage(Long id)throws ServiceException;
}
