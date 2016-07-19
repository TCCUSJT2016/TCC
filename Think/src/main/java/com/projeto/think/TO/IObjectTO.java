package com.projeto.think.TO;

import java.util.ArrayList;

public interface IObjectTO {

	public void adicionar(Object object);
	
	public boolean remover(Object object);
	
	public ArrayList<Object> consultar();
	
}
