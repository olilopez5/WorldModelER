package com.project.modelER.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="MODELOS-R")

public class ModeloRelacional {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer level;
	
	@Column
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getImagen() {
		return image;
	}

	public void setImagen(String image) {
		this.image = image;
	}
	
}
