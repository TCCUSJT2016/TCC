package com.projeto.think.Model;

import java.io.Serializable;

public class NivelPergunta extends Item implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public NivelPergunta()
	{
		super();
	}
	
	public NivelPergunta(int id, String descricao) 
	{
		super(id, descricao);
	}
}
