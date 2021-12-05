package edu.gmu.swe642.exception.mapper;

import edu.gmu.swe642.exception.SQLExecutionException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SQLExecutionExceptionMapper implements ExceptionMapper<SQLExecutionException> {

	@Override
	public Response toResponse(SQLExecutionException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorProperties("501", exception.getMessage()))
				.build();
	}
}
