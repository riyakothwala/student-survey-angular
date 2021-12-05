package edu.gmu.swe642.exception;

/**
 * The student already exists custom exception class to be used when user tries
 * to post data with existing unique ID.
 * 
 * @author Riya & Andrea
 */
public class StudentDataExistsException extends GenericRuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentDataExistsException(String message) {
		super(message);
	}
}
