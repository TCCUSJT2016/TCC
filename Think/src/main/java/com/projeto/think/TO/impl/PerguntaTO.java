package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Pergunta;
import com.projeto.think.TO.IObjectTO;

public class PerguntaTO implements IObjectTO, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> perguntas;

	public PerguntaTO() {
		perguntas = new ArrayList<Object>();
	}

	public void adicionar(Object object) {
		if (object instanceof Pergunta) {
			this.perguntas.add((Pergunta) object);
		}
	}

	public boolean remover(Object object) {
		if(object instanceof Pergunta) {
			return this.perguntas.remove((Pergunta) object);
		}
		return false;
	}

	public ArrayList<Object> consultar() {
		return this.perguntas;
	}

}
