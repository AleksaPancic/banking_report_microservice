package com.example.bvnk_report_microservice.exception;

import com.example.bvnk_report_microservice.entities.Report;
import com.example.bvnk_report_microservice.util.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ResponseHelper> handleException(final IllegalArgumentException e) {
		ResponseHelper responseHelper = new ResponseHelper();
		responseHelper.setStatus(HttpStatus.BAD_REQUEST);
		responseHelper.setMessage(e.getMessage());
		responseHelper.setDate(ZonedDateTime.now());
		responseHelper.setStackTraceElement(e.getStackTrace());

		return new ResponseEntity<>(responseHelper, HttpStatus.BAD_REQUEST);
	}

}
