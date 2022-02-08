package com.bolivar.pacifico.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.dao.IReportDao;
import com.bolivar.pacifico.models.entitys.Report;

@Service
public class IReportServiceImpl implements IReportService{

	@Autowired
	IReportDao iReportDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Report> listReport() {
		return (List<Report>) iReportDao.findAll();
	}

	@Override
	public void procedimiento() {
		jdbcTemplate.update("CALL SECONDREPORT()");
		
	}

}
