package com.projeto.think.Model;

public class Pergunta extends Item {
	
	private int  pontuacao;
	private long tempoResposta;
	private Area area;
	private Categoria categoria;
	private Subcategoria subcategoria;
	
	public Pergunta()
	{
		super();
	}
	
	public Pergunta(int id, String descricao, int pontuacao, long tempoResposta, Area area, Categoria categoria, Subcategoria subcategoria)
	{
		super(id, descricao);
		
		this.setPontuacao(pontuacao);
		this.setTempoResposta(tempoResposta);
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

	public long getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(long tempoResposta) {
		this.tempoResposta = tempoResposta;
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
