package com.bolivar.pacifico.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bolivar.pacifico.models.entitys.Report;


public interface IReportDao extends CrudRepository<Report, String>{
	
	@Query(value="{call FIRSTREPORT()}", nativeQuery=true)
	List<Report> listReport();

}
