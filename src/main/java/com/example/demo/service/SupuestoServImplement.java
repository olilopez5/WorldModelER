package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supuesto;
import com.example.demo.repository.SupuestoRepository;


@Service
public class SupuestoServImplement implements SupuestoService {
	
	
	
	@Autowired
	SupuestoRepository supuestoRepository;

	@Override
	public List<Supuesto> findAllSupuestos() {
		
		return supuestoRepository.findAll();
	}

}
