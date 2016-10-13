package com.projeto.think.TO.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.projeto.think.Model.Empresa;
import com.projeto.think.TO.IObjectTO;

public class EmpresaTO implements IObjectTO, Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> empresas;

	public EmpresaTO() {
		empresas = new ArrayList<Object>();
	}

	public void adicionar(Object object) {
		if (object instanceof Empresa) {
			this.empresas.add(object);
		}
	}

	public boolean remover(Object object) {
		if (object instanceof Empresa) {
			return this.empresas.remove(object);
		}
		return false;
	}

	public ArrayList<Object> consultar() {
		return this.empresas;
	}
}
