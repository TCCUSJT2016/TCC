/**
 * 
 */
package com.projeto.think.Model;

/**
 * @author Mauricio Souza Couto
 * Classe que mapeia o nível do Candidato
 */
public class NivelCandidato extends Item {
	
	private int pontuacaoMinima;
	private int pontuacaoMaxima;
	
	public NivelCandidato()
	{
		super();
		this.setPontuacaoMinima(-1);
		this.setPontuacaoMaxima(0);
	}
	
	public NivelCandidato(int id, String descricao, int pontuacaoMinima, int pontuacaoMaxima)
	{
		super(id, descricao);
		this.setPontuacaoMinima(pontuacaoMinima);
		this.setPontuacaoMaxima(pontuacaoMaxima);
	}
	
	public int getPontuacaoMinima() 
	{
		return pontuacaoMinima;
	}
	
	public void setPontuacaoMinima(int pontuacaoMinima) 
	{
		this.pontuacaoMinima = pontuacaoMinima;
	}
	
	public int getPontuacaoMaxima()
	{
		return pontuacaoMaxima;
	}
	
	public void setPontuacaoMaxima(int pontuacaoMaxima) 
	{
		this.pontuacaoMaxima = pontuacaoMaxima;
	}
}
