package com.tradeshift.exception;

public class NoDescendantsFoundException extends RuntimeException
{
	private static final long serialVersionUID = -8572961512918780504L;

	public NoDescendantsFoundException(String message) {
		super(message);
	}

}
