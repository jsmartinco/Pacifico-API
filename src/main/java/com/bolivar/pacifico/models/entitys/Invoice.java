package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="INVOICE")
@Data
public class Invoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceid;
	
	@Column(name = "CUTOFFDATE", nullable = false, length = 36)
	private Date cutoffdate;
	
	@Column(name = "KWH", nullable = false, length = 36)
	private double kwh;
	
	@Column(name = "PRICE", nullable = false, length = 20)
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	Customer customer;

	public Long getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Long invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Date getCutoffdate() {
		return cutoffdate;
	}

	public void setCutoffdate(Date cutoffdate) {
		this.cutoffdate = cutoffdate;
	}

	public double getKwh() {
		return kwh;
	}

	public void setKwh(double kwh) {
		this.kwh = kwh;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
