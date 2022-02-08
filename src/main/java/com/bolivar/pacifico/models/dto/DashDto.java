package com.bolivar.pacifico.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class DashDto {
	
	private String state;
	private String name;
	private double kwh;
	
	
	public DashDto(String state, String name, double kwh) {
		this.state = state;
		this.name = name;
		this.kwh = kwh;
	}
	
	public double getkwh() {
		return kwh;
	}
	public void setkwh(int kwh) {
		this.kwh = kwh;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
