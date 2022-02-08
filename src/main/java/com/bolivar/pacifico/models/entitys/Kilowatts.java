package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "KILOWATTS")
@Data
public class Kilowatts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kilowattid;
	
	@Column(name = "PRICE", nullable = false, length = 22)
	private double price;
	
	

}
