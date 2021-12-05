package edu.gmu.swe642.exception.mapper;

import edu.gmu.swe642.exception.StudentDataExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class StudentDataExistsExceptionMapper implements ExceptionMapper<StudentDataExistsException> {

	@Override
	public Response toResponse(StudentDataExistsException exception) {
		return Response.status(Status.CONFLICT).entity(new ErrorProperties("409", exception.getMessage())).build();
	}
}
