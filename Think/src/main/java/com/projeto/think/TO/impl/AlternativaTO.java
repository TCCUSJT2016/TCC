package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Alternativa;
import com.projeto.think.TO.IObjectTO;

public class AlternativaTO implements IObjectTO, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> alternativas;
	
	public AlternativaTO() {
		alternativas = new ArrayList<Object>();
	}

	public void adicionar(Object object) {
		if(object instanceof Alternativa) {
			this.alternativas.add(object);
		}

	}

	public boolean remover(Object object) {
		if(object instanceof Alternativa) {
			return this.alternativas.remove(object);
		}
		return false;
	}

	public ArrayList<Object> consultar() {
		return this.alternativas;
	}

}
