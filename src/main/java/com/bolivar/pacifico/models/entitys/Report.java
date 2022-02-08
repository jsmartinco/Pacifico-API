package com.bolivar.pacifico.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="REPORT")
public class Report {
	
	@Id
	@Column(name = "TOWN", length = 100)
	private String town;
	
	@Column(name = "AVGLASTYEAR", length = 20)
	private double avgLastYear;
	
	@Column(name = "LASTINVOICE", length = 20)
	private double lastInvoice;
	
	@Column(name = "DIFFERENCE", length = 20)
	private double difference;
	

}
