package com.compass.projetodoacao.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ONGFormDTO {

	private Integer id;
	
	@NotNull @NotEmpty
	private String filialONG;
	
	@NotNull @NotEmpty
	private String telefone;
	
	@NotNull @NotEmpty
	private String logradouro;
	@NotNull @NotEmpty
	private String numero;
	
	private String complemento;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String estado;
	@NotNull @NotEmpty
	private String cep;
	public Integer getId() {
		return id;
	}
	public String getFilialONG() {
		return filialONG;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getCep() {
		return cep;
	}
}
