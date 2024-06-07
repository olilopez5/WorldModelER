package com.project.modelER.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelER.entity.ModeloER;

public interface ModeloERRepository  extends JpaRepository< ModeloER ,Long>{
	List<ModeloER> findAllByLevel(Integer level);
}
