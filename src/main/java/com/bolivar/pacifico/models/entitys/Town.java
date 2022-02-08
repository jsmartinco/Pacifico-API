package com.bolivar.pacifico.models.entitys;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "TOWN")
@Data
public class Town implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long townid;
	
	@Column(name = "TNAME", nullable = false, length = 50)
	private String tname;

	public Long getTownid() {
		return townid;
	}

	public void setTownid(Long townid) {
		this.townid = townid;
	}

	public String gettname() {
		return tname;
	}

	public void settName(String name) {
		this.tname = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
