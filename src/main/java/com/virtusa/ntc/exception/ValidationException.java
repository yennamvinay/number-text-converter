package com.virtusa.ntc.exception;

/**
 * Represents validation exception
 */
public class ValidationException extends RuntimeException {

	/** Serial ID */
	private static final long serialVersionUID = -9033175020727343033L;

	/**
	 * Constructor
	 * 
	 * @param msg String
	 */
	public ValidationException(String msg) {
		super(msg);
	}

}
