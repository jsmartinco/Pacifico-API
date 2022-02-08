package com.bolivar.pacifico.models.criteria;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;

@Data
public class TicketCriteria {
	
	private StringFilter employee;
	private StringFilter state;
	private StringFilter town;
	private StringFilter prioirity;
	
	

}
