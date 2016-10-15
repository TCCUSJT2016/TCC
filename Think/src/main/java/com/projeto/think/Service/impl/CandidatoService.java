package com.projeto.think.Service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.projeto.think.Common.Enum.PerfilEnum;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.impl.AlternativaDAO;
import com.projeto.think.Repository.impl.CandidatoDAO;
import com.projeto.think.Service.IService;
import com.projeto.think.TO.IObjectTO;

@Component
public class CandidatoService implements IService
{
	private CandidatoDAO candidatoDAO = null;
	private Map<String, Object> resultado = null;
	
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
	
	public Map<String, Object> alterarPerfil(IObjectTO objectTO, PerfilEnum perfil) {

		try {
			resultado = new HashMap<String, Object>();
			candidatoDAO = new CandidatoDAO();

			resultado = candidatoDAO.alterarPerfil(objectTO, perfil);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}
}
