package com.projeto.think.Service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.projeto.think.Repository.impl.CandidatoDAO;
import com.projeto.think.Service.IService;
import com.projeto.think.TO.IObjectTO;

@Component
public class CandidatoService implements IService
{
	private CandidatoDAO candidatoDAO = new CandidatoDAO();

	public Map<String, Object> cadastrar(IObjectTO objectTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> alterar(IObjectTO objectTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> excluir(IObjectTO objectTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> consultar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
