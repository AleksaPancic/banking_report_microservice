package com.example.bvnk_report_microservice.service;

import com.example.bvnk_report_microservice.DTO.ReportDto;
import com.example.bvnk_report_microservice.entities.Report;


public interface ReportService {

	/**
	 * Fetches the report for the specified client ID.
	 *
	 * @param  clientId  the ID of the client for whom to fetch the report
	 * @return           the report associated with the client ID
	 */
	Report fetchReportForClientId(Long clientId);

	ReportDto updateReport(ReportDto reportDto);

	/**
	 * Generates a function comment for the given function body in a markdown code block with the correct language syntax.
	 *
	 * @param  reportDto  the ReportDto object containing the necessary data for creating a report
	 * @return            the created ReportDto object
	 */
	ReportDto createReport(ReportDto reportDto);

}
