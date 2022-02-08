package com.bolivar.pacifico.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bolivar.pacifico.models.entitys.ReportTwo;


public interface IReport2Dao extends CrudRepository<ReportTwo, String>{
	
	@Query(value="{call SECONDREPORT()}", nativeQuery=true)
	List<ReportTwo> listReport();
}
