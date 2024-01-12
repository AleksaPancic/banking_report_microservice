package com.example.bvnk_report_microservice.controller;

import com.example.bvnk_report_microservice.DTO.ReportDto;
import com.example.bvnk_report_microservice.entities.Report;
import com.example.bvnk_report_microservice.repository.ReportDAO;
import com.example.bvnk_report_microservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/report")
public class ReportController {

	private final ReportService reportService;

	@Autowired
	public ReportController(final ReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/{clientId}")
	@CrossOrigin(origins = "http")
	public ResponseEntity<Report> getReportForCustomer(@RequestHeader Map<String, Object> headers, @PathVariable Long clientId) {
		//logic for checking headers, pulling from auth client and checking if auth token is valid etc
		return ResponseEntity.ok().body(reportService.fetchReportForClientId(clientId));
	}

	@PatchMapping("/update")
	@CrossOrigin(origins = "http")
	public ResponseEntity<String> updateReport(@RequestHeader Map<String, Object> headers, @RequestBody ReportDto reportDto) {
		final ReportDto reportDto2 = reportService.updateReport(reportDto); //make something else
		return ResponseEntity.ok()
							 .body(String.format("Report created for client with id: %s", reportDto.getClientId()) + reportDto);
	}

	@PostMapping("/create")
	@CrossOrigin(origins = "http")
	public ResponseEntity<String> createReport(@RequestHeader Map<String, Object> headers, @RequestBody ReportDto reportDto) {
		final ReportDto reportDto2 = reportService.createReport(reportDto); //make something else
		return ResponseEntity.ok()
							 .body(String.format("Report created for client with id: %s", reportDto.getClientId()) + reportDto);
	}
}
