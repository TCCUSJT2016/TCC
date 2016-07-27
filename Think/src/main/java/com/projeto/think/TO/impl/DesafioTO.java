package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Desafio;
import com.projeto.think.TO.IObjectTO;

public class DesafioTO implements IObjectTO, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> desafios;
	
	public DesafioTO() {
		desafios = new ArrayList<Object>(); 
	}

	public void adicionar(Object object) {
		if (object instanceof Desafio) {
			this.desafios.add((Desafio) object);
		}
	}

	public boolean remover(Object object) {
		if(object instanceof Desafio) {
			return this.desafios.remove((Desafio) object);
		}
		return false;
	}

	public ArrayList<Object> consultar() {
		return this.desafios;
	}

}
