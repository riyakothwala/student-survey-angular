package edu.gmu.swe642.exception;

/**
 * The generic custom exception class to be thrown upon generic application
 * problems.
 * 
 * @author Riya & Andrea
 */
public class GenericRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericRuntimeException(String message) {
		super(message);
	}
}
