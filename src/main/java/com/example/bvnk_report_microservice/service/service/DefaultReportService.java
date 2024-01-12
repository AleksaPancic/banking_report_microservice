package com.example.bvnk_report_microservice.service.service;

import com.example.bvnk_report_microservice.DTO.ReportDto;
import com.example.bvnk_report_microservice.entities.Report;
import com.example.bvnk_report_microservice.populator.impl.ReportPopulator;
import com.example.bvnk_report_microservice.repository.ReportDAO;
import com.example.bvnk_report_microservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class DefaultReportService implements ReportService {

	private final ReportDAO reportDAO;
	private final ReportPopulator reportPopulator;

	@Autowired
	public DefaultReportService(final ReportDAO reportDAO, final ReportPopulator reportPopulator) {
		this.reportDAO = reportDAO;
		this.reportPopulator = reportPopulator;
	}

	@Override
	public Report fetchReportForClientId(final Long clientId) {

		final Optional<Report> report = reportDAO.findByClientId(clientId);

		if (!report.isPresent() || clientId == null) {
			throw new IllegalArgumentException("Report not found for client with id: " + clientId);
		}
		return report.get();
	}

	@Transactional
	@Override
	public ReportDto updateReport(final ReportDto reportDto) {
		final Report report = fetchReportForClientId(reportDto.getClientId());
		reportPopulator.populate(reportDto, report);
		reportDAO.saveAndFlush(report);
		return reportDto;
	}

	@Transactional
	@Override
	public ReportDto createReport(final ReportDto reportDto) {
		final Report report = new Report();
		reportPopulator.populate(reportDto, report);
		reportDAO.saveAndFlush(report);
		return reportDto;
	}

}
