package com.project.modelER.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.SupuestoRepository;


@Service
public class SupuestoServImplement implements SupuestoService {
	
	
	
	@Autowired
	SupuestoRepository supuestoRepository;

	@Override
	public List<Supuesto> findAllSupuestos() {
		
		return supuestoRepository.findAll();
	}

	@Override
	public Supuesto saveSupuesto(Supuesto supuesto,MultipartFile file) {
		try {
			supuesto.setDocument(file.getBytes());
			return supuestoRepository.save(supuesto);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Supuesto updateSupuesto(Long id, Supuesto supuesto) {
		
		//if (supuesto==null)
			
		
		return null;
	}

	@Override
	public void deleteSupuesto(Long id) {
		supuestoRepository.deleteById(id);
		
	}

}
