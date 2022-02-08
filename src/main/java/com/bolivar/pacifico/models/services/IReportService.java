package com.bolivar.pacifico.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.entitys.Report;

@Service
public interface IReportService {
	
	public List<Report> listReport();
	
	public void procedimiento();

}
