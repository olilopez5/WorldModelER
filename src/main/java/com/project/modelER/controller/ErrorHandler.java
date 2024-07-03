package com.project.modelER.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.project.modelER.service.exception.ErrorCode;
import com.project.modelER.service.exception.ErrorMessage;
import com.project.modelER.service.exception.ServiceException;

@ControllerAdvice
public class ErrorHandler {
	public static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

		@ExceptionHandler(Exception.class)
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		public String errorGeneralHadler(Model model) {
			
			log.info("[errorGeneralHadler]");
			log.info("[ErrorMessage:" + ErrorMessage.ERROR_GENERAL + "]");
			model.addAttribute("ErrorMessage", ErrorMessage.ERROR_GENERAL);
			return "error";
		}

		@ExceptionHandler(ServiceException.class)
		public String serviceExceptionHadler(ServiceException e, Model model) {
			log.info("[serviceExceptionHadler]");
			if (ErrorCode.LEVEL_NOT_FOUND.equals(e.getCodigo())) {
				log.debug("[ErrorMessage:" + ErrorMessage.LEVEL_NOT_FOUND + "]");
				model.addAttribute("ErrorMessage", ErrorMessage.LEVEL_NOT_FOUND);
				return "error"; // Volvemos a la vista del nivel
			}
			log.debug("[ErrorMessage:" + ErrorMessage.ERROR_GENERAL + "]");
			model.addAttribute("ErrorMessage", ErrorMessage.ERROR_GENERAL);
			return "error"; // Volvemos a la vista de errores
		}

	}


