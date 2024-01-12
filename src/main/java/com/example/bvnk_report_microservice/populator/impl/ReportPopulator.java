package com.example.bvnk_report_microservice.populator.impl;

import com.example.bvnk_report_microservice.DTO.ReportDto;
import com.example.bvnk_report_microservice.entities.Report;
import com.example.bvnk_report_microservice.populator.Populator;
import org.springframework.stereotype.Component;


@Component
public class ReportPopulator implements Populator<ReportDto, Report> {
	@Override
	public void populate(final ReportDto source, Report target) {
		target.setClientId(source.getClientId());
		target.setReportName(source.getReportName());
		target.setReportDescription(source.getReportDescription());
	}

}
