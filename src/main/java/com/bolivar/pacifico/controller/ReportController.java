package com.bolivar.pacifico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.pacifico.models.entitys.Report;
import com.bolivar.pacifico.models.entitys.ReportTwo;
import com.bolivar.pacifico.models.services.IReport2Service;
import com.bolivar.pacifico.models.services.IReportService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {
	
	@Autowired
	public IReportService iReportService;
	
	@Autowired
	public IReport2Service iReport2Service;
	
	@GetMapping("/reports")
	public List<Report> findReport(){
		iReport2Service.procedimiento();
		return iReportService.listReport();
		
	}
	
	@GetMapping("/reports2")
	public List<ReportTwo> findReport2(){
		iReport2Service.procedimiento();
		return iReport2Service.listReport();
		
	}
}
