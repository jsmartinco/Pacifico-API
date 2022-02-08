package com.bolivar.pacifico.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.entitys.ReportTwo;

@Service
public interface IReport2Service {
	
	public List<ReportTwo> listReport();
	
	public void procedimiento();
	

}
