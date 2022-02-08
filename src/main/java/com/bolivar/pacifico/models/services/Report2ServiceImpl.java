package com.bolivar.pacifico.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.dao.IReport2Dao;
import com.bolivar.pacifico.models.entitys.ReportTwo;

@Service
public class Report2ServiceImpl implements IReport2Service{

	@Autowired
	IReport2Dao iReport2Dao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ReportTwo> listReport() {
			return (List<ReportTwo>) iReport2Dao.findAll();
	}

	@Override
	public void procedimiento() {
		jdbcTemplate.update("CALL FIRSTREPORT()");
	}

	
	
	

}
