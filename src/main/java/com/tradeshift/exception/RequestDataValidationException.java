package com.tradeshift.exception;

public class RequestDataValidationException extends RuntimeException
{
	private static final long serialVersionUID = -8572961512918780504L;

	public RequestDataValidationException() {
		super();
	}

	public RequestDataValidationException(String message) {
		super(message);
	}

	public RequestDataValidationException(Throwable cause) {
		super(cause);
	}
    
	
}
