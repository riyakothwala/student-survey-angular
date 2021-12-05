package edu.gmu.swe642.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorProperties("500", exception.getMessage()))
				.build();
	}

}
