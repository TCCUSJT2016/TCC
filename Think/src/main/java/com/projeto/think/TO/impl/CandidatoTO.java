package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Candidato;
import com.projeto.think.TO.IObjectTO;

public class CandidatoTO implements IObjectTO, Serializable
{

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> candidatos;
	
	public CandidatoTO()
	{
		candidatos = new ArrayList<Object>();
	}

	public void adicionar(Object object)
	{
		if(object instanceof Candidato )
		{
			this.candidatos.add((Candidato) object);
		}
	}

	public boolean remover(Object object) 
	{
		if(object instanceof Candidato)
		{
			return this.candidatos.remove((Candidato) object);
		}
		
		return false;
	}

	public ArrayList<Object> consultar() 
	{
		return this.candidatos;
	}

}
