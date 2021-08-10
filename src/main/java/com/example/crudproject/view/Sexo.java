package com.example.crudproject.view;

public enum Sexo {
	MASCULINO("masculino"),
	FEMININO("feminino");
	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
