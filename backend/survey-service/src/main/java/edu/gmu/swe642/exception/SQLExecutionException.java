package edu.gmu.swe642.exception;

/**
 * The SQL execution custom exception class to be used for SQL query related
 * problems.
 * 
 * @author Riya & Andrea
 */
public class SQLExecutionException extends DatabaseException {

	private static final long serialVersionUID = 1L;

	public SQLExecutionException(String message) {
		super(message);
	}
}
