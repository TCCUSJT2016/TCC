package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Perfil;
import com.projeto.think.TO.IObjectTO;

public class PerfilTO implements IObjectTO, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> listaPerfil;

	public PerfilTO() {
		listaPerfil = new ArrayList<Object>();
	}

	public void adicionar(Object object) {
		if (object instanceof Perfil) {
			this.listaPerfil.add(object);
		}
	}

	public boolean remover(Object object) {
		if (object instanceof Perfil) {
			return this.listaPerfil.remove(object);
		}
		return false;
	}

	public ArrayList<Object> consultar() {
		return this.listaPerfil;
	}
}
