package edu.gmu.swe642.exception.mapper;

import edu.gmu.swe642.exception.StudentDataNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class StudentDataNotFoundExceptionMapper implements ExceptionMapper<StudentDataNotFoundException> {

	@Override
	public Response toResponse(StudentDataNotFoundException exception) {
		return Response.status(Status.NOT_FOUND).entity(new ErrorProperties("404", exception.getMessage())).build();
	}

}
