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

	@Override
	public Supuesto saveSupuesto(Supuesto supuesto) {
		
		return supuestoRepository.save(supuesto);
	}

	@Override
	public Supuesto updateSupuesto(Long id, Supuesto supuesto) {
		
		return null;
	}

	@Override
	public void deleteSupuesto(Long id) {
		supuestoRepository.deleteById(id);
		
	}

}
