package com.bolivar.pacifico.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "REPORT2")
public class ReportTwo {
	
	@Id
	@Column(name = "TOWN", length = 100)
	private String town;
	
	@Column(name = "STOLEN", length = 100)
	private double stolen;
	
	@Column(name = "ILEGALCON", length = 100)
	private double ilegalcon;
	
	@Column(name = "ALTERATION", length = 100)
	private double alteration;
	
	@Column(name = "TOTAL", length = 100)
	private double total;

}
