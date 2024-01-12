package com.example.bvnk_report_microservice.DTO;

import lombok.Value;

import java.io.Serializable;


/**
 * DTO for {@link com.example.bvnk_report_microservice.entities.Report}
 */
@Value
public class ReportDto implements Serializable {
	Long clientId;
	String reportName;
	String reportDescription;
}