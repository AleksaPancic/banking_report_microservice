package com.example.bvnk_report_microservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "reports")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;

	@Column(name = "client_id")
	private Long clientId; //reference id to the Client microservice (kinda like foreign key)
	@Column(name = "report_name")
	private String reportName;
	@Column(name = "report_description")
	private String reportDescription;

}


