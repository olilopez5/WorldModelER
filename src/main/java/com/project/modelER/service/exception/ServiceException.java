package com.project.modelER.service.exception;

@SuppressWarnings("serial")

public class ServiceException extends Exception {

	final String codigo;

	public ServiceException(String codigo, Exception e) {
		super(e.getMessage());
		this.codigo = codigo;
	}

	public ServiceException(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

}
