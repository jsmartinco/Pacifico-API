package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;
	
	@Column(name = "CNAME", nullable = false, length = 100)
	private String cname;
	
	@Column(name = "ADDRESS", nullable = false, length = 100)
	private String address;
	
	@Column(name = "ADDITIONALINFO", nullable = true, length = 100)
	private String additionalinfo;
	
	@Column(name ="TYPEDOCUMENT", nullable = false, length = 10)
	private String typedocument;
	
	@Column(name = "DOCUMENT", nullable = false, length = 100)
	private String document;
	
	@Column(name = "PRIORITY", nullable = false, length = 100)
	private String priority;
	
	@Column(name = "STATE", nullable = false, length = 22)
	private int state;
	
	@Column(name = "STRATUM", nullable = false, length = 1)
	private int stratum;
	
	@ManyToOne
	@JoinColumn(name = "townid")
	private Town town;

	
	
}
