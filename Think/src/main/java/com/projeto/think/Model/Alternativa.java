package com.projeto.think.Model;

public class Alternativa extends Item {
	
	private boolean correta;
	private Pergunta pergunta;
	
	public Alternativa()
	{
		super();
	}
	
	public Alternativa(int id, String descricao, boolean correta, Pergunta pergunta)
	{
		super(id, descricao);
		
		this.setCorreta(correta);
		this.setPergunta(pergunta);		
	}
		
	public boolean isCorreta() {
		return correta;
	}
	
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	
	
}
