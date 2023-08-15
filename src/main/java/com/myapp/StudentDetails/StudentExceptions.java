package com.myapp.StudentDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptions {

	@ExceptionHandler(AgeException.class)

	public ResponseEntity<Object> AgeException(AgeException n) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}

}
