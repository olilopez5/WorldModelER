package com.project.modelER.service;

import java.util.List;

import com.project.modelER.entity.Supuesto;

public interface SupuestoService {
	List<Supuesto> findAllSupuestos();

	Supuesto saveSupuesto(Supuesto supuesto);

	Supuesto updateSupuesto(Long id, Supuesto supuesto);

	void deleteSupuesto(Long id);

}
