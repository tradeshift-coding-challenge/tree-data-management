package com.tradeshift.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {RequestDataValidationException.class})
	@ResponseBody
	final ErrorResponse handleBadRequestException(HttpServletRequest req, Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage());
		return errorResponse;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {NoDescendantsFoundException.class})
	@ResponseBody
	final ErrorResponse handleNoDataFound(HttpServletRequest req, Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage());
		return errorResponse;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
	final ErrorResponse handleAllOtherException(HttpServletRequest req, Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage());
		return errorResponse;
	}
}