package com.nelioalves.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public ValidationError(Integer status, String msg, long timeStamp, List<FieldError> fieldErrors) {
		this(status, msg, timeStamp);
		super.setMsg("Erro de validação");
		fieldErrors.forEach(x -> addErrors(x.getField(), x.getDefaultMessage()));
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addErrors(String field, String msg) {
		errors.add(new FieldMessage(field, msg));
	}

}
