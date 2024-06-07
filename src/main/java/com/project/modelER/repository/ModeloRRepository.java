package com.project.modelER.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelER.entity.ModeloRelacional;

public interface ModeloRRepository  extends JpaRepository< ModeloRelacional ,Long>{
	List<ModeloRelacional> findAllByLevel(Integer level);
}
