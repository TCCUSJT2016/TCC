package com.projeto.think.Model;

import java.io.Serializable;

/**
 * @author Cleberson Costa
 *
 * @description Está classe é apenas um POJO.
 */
public class Cargo extends Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Cargo() {
		super();
	}
	
	public Cargo(int id, String descricao) {
		super(id, descricao);
	}
}
