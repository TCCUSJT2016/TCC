package com.projeto.think.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.projeto.think.Repository.impl.CandidatoDAO;
import com.projeto.think.Service.IService;

@Component
public class CandidatoService implements IService
{
	private CandidatoDAO candidatoDAO = new CandidatoDAO();
	
	public Map<String, Object> cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> cadastrar(List<Object> objects) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
