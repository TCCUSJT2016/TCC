package com.projeto.think.Model;

import java.io.Serializable;

/**
 * @author ClebersonCosta
 *
 * @description Está classe é apenas um POJO.
 */
public class Departamento extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Departamento() {
		super();
	}
	
	public Departamento(int id, String descricao) {
		super(id, descricao);
	}
}
