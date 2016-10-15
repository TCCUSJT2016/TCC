package com.projeto.think.Model;

import com.projeto.think.Common.Enum.AlternativaEnum;

public class AlternativaPerfil extends Item {
	
	private Pergunta pergunta;
	
	private AlternativaEnum selecionada;
	
	public AlternativaPerfil()
	{
		super();
	}
	
	public AlternativaPerfil(int id, String descricao, Pergunta pergunta)
	{
		super(id, descricao);
		
		this.setPergunta(pergunta);		
	}
		
	public Pergunta getPergunta() {
		return pergunta;
	}	
	
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	public void setSelecionada(AlternativaEnum selecionada){
		this.selecionada = selecionada;
	}
	
	public AlternativaEnum getSelecionada() {
		return selecionada;
	}
}
