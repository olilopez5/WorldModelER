package com.project.modelER.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "SOLUCIONES")

public class Solucion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "cbsfid")
    private Supuesto supuesto;

    @ManyToOne
    @JoinColumn(name = "dfgagid")
    private ModeloER modeloER;

    @ManyToOne
    @JoinColumn(name = "rgadgfid")
    private MRelacional mRelacional;
	
}
