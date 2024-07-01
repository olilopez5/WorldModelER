package com.project.modelER.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.modelER.entity.Supuesto;
import com.project.modelER.repository.SupuestoRepository;


@Service
public class SupuestoServImplement implements SupuestoService {
	public static final Logger log = LoggerFactory.getLogger(SupuestoServImplement.class);
	
	
	@Autowired
	SupuestoRepository supuestoRepository;

	@Override
	public List<Supuesto> findAllSupuestos() {
		log.info("[findAllSupuestos]");
		
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

	@Override
	public Supuesto getServicio(Long id) {
		try {
			Optional<Supuesto> opSupuesto = supuestoRepository.findById(id);
			if(!opSupuesto.isPresent()) {
				//TODO mandas excepcion
			}
			return opSupuesto.get();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
