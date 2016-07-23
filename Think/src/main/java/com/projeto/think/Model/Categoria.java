package com.projeto.think.Model;

import java.io.Serializable;

public class Categoria extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Area area;
	
	public Categoria()
	{
		super();
	}
	
	public Categoria(int id, String descricao, Area area)
	{
		super(id, descricao);
		this.setArea(area);
	}
	
	public Categoria(int id) {
		super(id, null);
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
