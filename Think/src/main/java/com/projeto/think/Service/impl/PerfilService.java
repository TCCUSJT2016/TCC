package com.projeto.think.Service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.impl.PerfilDAO;
import com.projeto.think.Service.IService;
import com.projeto.think.TO.IObjectTO;

@Service
public class PerfilService implements IService
{
	private IDAO perfilDAO = null;
	private Map<String, Object> resultado = null;
	
	public Map<String, Object> consultarPorId(int id) 
	{
		try 
		{
			resultado = new HashMap<String, Object>();
			perfilDAO = new PerfilDAO();

			resultado = perfilDAO.consultar(id);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return resultado;
	}

	public Map<String, Object> consultar() 
	{
		try 
		{
			resultado = new HashMap<String, Object>();
			perfilDAO = new PerfilDAO();

			resultado = perfilDAO.consultar();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return resultado;
	}

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
}
