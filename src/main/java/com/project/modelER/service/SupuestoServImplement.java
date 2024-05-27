package com.project.modelER.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
