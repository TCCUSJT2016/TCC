package com.projeto.think.Repository;

import java.util.List;
import java.util.Map;

public interface IDAO {
	
	public Map<String, Object> consultar(int id);
	
	public Map<String, Object> consultar();
	
	public Map<String, Object> cadastrar(Object object);

	public Map<String, Object> cadastrar(List<Object> object);
	
	public Map<String, Object> alterar(Object object);
		
	public Map<String, Object> alterar(List<Object> objects);
	
	public Map<String, Object> excluir(Object object);
	
	public Map<String, Object> excluir(List<Object> objects);
}
