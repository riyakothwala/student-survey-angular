package edu.gmu.swe642.exception;

/**
 * The student not found custom exception class to be used when user queries for
 * the student data that does not exist.
 * 
 * @author Riya & Andrea
 */
public class StudentDataNotFoundException extends GenericRuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentDataNotFoundException(String message) {
		super(message);
	}
}
