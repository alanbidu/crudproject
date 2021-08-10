package com.example.crudproject.view;

public enum EstadoCivil {
	SOLTEIRO("solteiro"),
	CASADO("casado"),
	VIUVO("viuvo"),
	SEPARADO("separado");
	
	private String descricao;
	
	EstadoCivil(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
