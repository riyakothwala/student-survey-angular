package edu.gmu.swe642.exception.mapper;

import edu.gmu.swe642.exception.DatabaseException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DatabaseExceptionMapper implements ExceptionMapper<DatabaseException> {

	@Override
	public Response toResponse(DatabaseException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorProperties("502", exception.getMessage()))
				.build();
	}
}
