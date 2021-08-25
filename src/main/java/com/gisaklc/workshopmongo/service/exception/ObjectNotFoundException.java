package com.gisaklc.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Runtime nao exige tratamento

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
