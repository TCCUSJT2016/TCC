package com.projeto.think.Service;

import java.util.Map;

public interface IService {

	public Map<String, Object> cadastrar(Object object);
	
	public Map<String, Object> consultarPorId(int id);
}
