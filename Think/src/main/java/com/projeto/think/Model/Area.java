package com.projeto.think.Model;

import java.io.Serializable;

public class Area extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	public Area()
	{
		super();
	}
	
	public Area(int id, String descricao) 
	{
		super(id, descricao);
	}
}
