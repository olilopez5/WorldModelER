package com.project.modelER.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelER.entity.MRelacional;

public interface MRelacionalRepository  extends JpaRepository< MRelacional ,Long>{
	List<MRelacional> findAllByLevel(Integer level);
}
