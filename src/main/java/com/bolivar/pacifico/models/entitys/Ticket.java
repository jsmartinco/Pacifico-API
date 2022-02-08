package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name = "TICKET")
@Data
public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketid;
	
	//CREATEDATE,,OBSERVATIONS,CONDITIONS,STATE,INVOICEID,EMPLOYEEID,DIFFERENCE
	
	@Column(name = "CREATEDATE", nullable=false, length = 7)
	private Date createdate;
	
	@Column(name = "FRAUD", nullable=true, length = 1)
	private Integer fraud;
	
	@Column(name = "OBSERVATIONS", nullable = true, length = 500)
	private String observations;
	
	@Column(name="CONDITIONS", nullable = true, length = 20)
	private String conditions;
	
	@Column(name="STATE", nullable = false, length = 10)
	private String state; 
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="INVOICEID")
	private Invoice invoice;
	
	@Column(name = "DIFFERENCE", nullable = true, length = 22)
	private double difference;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEEID")
	private Employee employee;
	
	
	public Long getTICKETID() {
		return ticketid;
	}

	public void setTICKET(Long ticketid) {
		this.ticketid = ticketid;
	}

	public Date getCREATEDATE() {
		return createdate;
	}

	public void setCREATEDATE(Date createdate) {
		this.createdate = createdate;
	}

	public int getFRAUD() {
		return fraud;
	}

	public void setFRAUD(int fraud) {
		this.fraud = fraud;
	}

	public String getOBSERVATIONS() {
		return observations;
	}

	public void setOBSERVATIONS(String observations) {
		this.observations = observations;
	}

	public String getCONDITIONS() {
		return conditions;
	}

	public void setCONDITIONS(String conditions) {
		this.conditions = conditions;
	}

	public String getSTATE() {
		return state;
	}

	public void setSTATE(String state) {
		this.state = state;
	}

	public Invoice getINVOICE() {
		return invoice;
	}

	public void setINVOICE(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public double getDIFFERENCE() {
		return difference;
	}

	public void setDiFFERENCE(double difference) {
		this.difference = difference;
	}

	public Employee getEMPLOYEE() {
		return employee;
	}

	public void setEMPLOYEE(Employee employee) {
		this.employee = employee;
	}

	
	
	 
	
}
