package com.example.bvnk_report_microservice.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@Data
public class ResponseHelper {

	private HttpStatus status;
	private String message;
	private ZonedDateTime date;
	private StackTraceElement[] stackTraceElement;

}
