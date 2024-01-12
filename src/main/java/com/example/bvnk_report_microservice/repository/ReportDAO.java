package com.example.bvnk_report_microservice.repository;

import com.example.bvnk_report_microservice.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface ReportDAO extends JpaRepository<Report, Long> {

	@Query("SELECT r FROM Report r WHERE r.clientId = :clientId")
	Optional<Report> findByClientId(@Param("clientId") Long clientId);

}
