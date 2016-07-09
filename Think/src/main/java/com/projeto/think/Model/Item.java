package com.projeto.think.Model;

/**
 * @author Mauricio Souza Couto
 * @description Model - Classe abstrata contendo itens id e descricao que serão herdados pelas demais classes. 
 */
public abstract class Item
{
	protected int id;
	protected String descricao;
	
	public Item()
	{
		this.setId(0);
		this.setDescricao(null);
	}
	
	public Item(int id, String descricao)
	{
		this.setId(id);
		this.setDescricao(descricao);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
