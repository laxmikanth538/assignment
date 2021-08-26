package com.lark.assignment.artechassignment.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lark.assignment.artechassignment.payload.ArtErrorEntity;

@ControllerAdvice
public class ArtErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Numeric input expected, received invalid charactes in input";
		return buildResponseEntity(new ArtErrorEntity("FAILED", error));
	}

	private ResponseEntity<Object> buildResponseEntity(ArtErrorEntity apiError) {
		return ResponseEntity.badRequest().body(apiError);
	}

}
