package edu.gmu.swe642.exception.mapper;

import edu.gmu.swe642.exception.GenericRuntimeException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericRuntimeExceptionMapper implements ExceptionMapper<GenericRuntimeException> {

	@Override
	public Response toResponse(GenericRuntimeException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorProperties("510", exception.getMessage()))
				.build();
	}

}
