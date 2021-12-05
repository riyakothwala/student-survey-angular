package edu.gmu.swe642.exception;

/**
 * The generic databse custom exception class to be used for common database
 * configuration problems.
 * 
 * @author Riya & Andrea
 */
public class DatabaseException extends GenericRuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String message) {
		super(message);
	}
}
