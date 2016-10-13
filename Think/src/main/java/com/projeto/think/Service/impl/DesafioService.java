package com.projeto.think.Service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.projeto.think.Model.Desafio;
import com.projeto.think.Repository.impl.DesafioDAO;

@Service
public class DesafioService {

	private DesafioDAO dd = null;
	private Map<String, Object> resultado = null;
	
	public Map<String, Object> aceitaDesafio(Desafio desafio) {
		
		try {
			resultado = new HashMap<String, Object>();
			
			dd = new DesafioDAO();
			resultado =  dd.aceitaDesafio(desafio);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	
}
