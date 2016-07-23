package com.projeto.think.Service;

import java.util.Map;

import com.projeto.think.TO.IObjectTO;

public interface IService {

	public Map<String, Object> cadastrar(IObjectTO objectTO);
	
	public Map<String, Object> alterar(IObjectTO objectTO);
	
	public Map<String, Object> excluir(IObjectTO objectTO);
	
	public Map<String, Object> consultarPorId(int id);
	
	public Map<String, Object> consultar();
}
