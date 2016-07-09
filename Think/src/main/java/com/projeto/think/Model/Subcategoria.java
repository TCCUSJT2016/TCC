package com.projeto.think.Model;

import java.io.Serializable;

public class Subcategoria extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Categoria categoria;

	public Subcategoria()
	{
		super();
	}
	
	public Subcategoria(int id, String descricao, Categoria categoria)
	{
		super(id, descricao);
		this.setCategoria(categoria);
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoriaSuperior) {
		this.categoria = categoriaSuperior;
	}
}
