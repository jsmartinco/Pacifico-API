package com.bolivar.pacifico.models.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TicketDetailsDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ticketid;
	private String tname;
	private String address;
	private String cname;
	private String additionalinfo;
	private String typedocument;
	private String document;
	private String priority;
	private String state;
	private double difference;
	private String observations;
	private int fraud;
	private String conditions;
	private String name;
	
	public TicketDetailsDto(Long ticketid, String tname, String address, String cname, String additionalinfo, String typedocument,
			String document, String priority, String state, double difference, String observations, String conditions, int fraud, String name) {
		this.ticketid = ticketid;
		this.tname = tname;
		this.address = address;
		this.cname = cname;
		this.additionalinfo = additionalinfo;
		this.typedocument = typedocument;
		this.document = document;
		this.priority = priority;
		this.state = state;
		this.difference = difference;
		this.observations = observations;
		this.conditions = conditions;
		this.fraud = fraud;
		this.name = name;
	}

	public TicketDetailsDto(String state, String name, String tname) {
		this.name = name;
		this.state = state;
		this.tname = tname;
	}
	
		


	
}




