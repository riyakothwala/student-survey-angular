package edu.gmu.swe642.exception.mapper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The error properties class to wrap the error code along with the error
 * message.
 * 
 * @author Riya & Andrea
 */
@XmlRootElement
public class ErrorProperties {

	private String status;
	private String errorMessage;

	public ErrorProperties(String status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
