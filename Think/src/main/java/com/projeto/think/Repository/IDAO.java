package com.projeto.think.Repository;

import java.util.Map;

import com.projeto.think.TO.IObjectTO;

public interface IDAO {
	
	public Map<String, Object> consultar(int id);
	
	public Map<String, Object> consultar();
	
	public Map<String, Object> cadastrar(IObjectTO objectTO);
	
	public Map<String, Object> alterar(IObjectTO objectTO);
	
	public Map<String, Object> excluir(IObjectTO objectTO);
}
