package com.project.modelER.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelER.entity.Supuesto;

public interface SupuestoRepository extends JpaRepository<Supuesto,Long> {

	 List<Supuesto> findAllByLevel(Integer level);
}
