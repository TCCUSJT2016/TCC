package com.projeto.think.Model;

import java.sql.Time;

public class Pergunta extends Item {
	
	private int  pontuacao;
	private Time tempoResposta;
	private NivelPergunta nivelPergunta;
	private Area area;
	private Categoria categoria;
	private Subcategoria subcategoria;
	
	public Pergunta()
	{
		super();
	}
	
	public Pergunta(int id) {
		super(id, null);
	}
	
	public Pergunta(int id, String descricao, int pontuacao, Time tempoResposta, NivelPergunta nivelPergunta, Area area, Categoria categoria, Subcategoria subcategoria)
	{
		super(id, descricao);
		
		this.setPontuacao(pontuacao);
		this.setTempoResposta(tempoResposta);
		this.setNivelPergunta(nivelPergunta);
		this.setArea(area);
		this.setCategoria(categoria);
		this.setSubcategoria(subcategoria);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Time getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(Time time) {
		this.tempoResposta = time;
	}
	
	public NivelPergunta getNivelPergunta() {
		return nivelPergunta;
	}
	
	public void setNivelPergunta(NivelPergunta nivelPergunta) {
		this.nivelPergunta = nivelPergunta;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
}
