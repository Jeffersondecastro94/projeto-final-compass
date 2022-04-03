package com.compass.projetodoacao.dto;

import com.compass.projetodoacao.entities.ONG;

public class ONGDTO {

	private Integer id;
	private String filial;

	public ONGDTO() {
	}

	public ONGDTO(ONG obj) {
		this.id = obj.getId();
		this.filial = obj.getFilial();
	}

	public Integer getId() {
		return id;
	}

	public String getFilial() {
		return filial;
	}
}
