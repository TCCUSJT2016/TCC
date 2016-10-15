package com.projeto.think.Repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.projeto.think.Common.Enum.PerfilEnum;
import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Candidato;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;
import com.projeto.think.TO.IObjectTO;

public class CandidatoDAO extends DatabaseConstants implements IDAO
{
	Map<String, Object> resultado = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	ConnectionFactory connectionFactory = null;
	
	public Map<String, Object> consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> consultar() {
		// TODO Auto-generated method stub
		return null;
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
	
	public Map<String, Object> alterarPerfil(IObjectTO objectTO, PerfilEnum perfil) 
	{
		for (Object candidato : objectTO.consultar())
		{
			if (candidato instanceof Candidato)
			{
				String query = "UPDATE tb_candidato SET idPerfil_FK = "+ 
				"(SELECT idPerfil_PK FROM tb_perfil WHERE codigoPerfil = '?')" +
						"WHERE idCandidato_PK = ?";
				try
				{
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setString(1, (perfil.toString()));
					statement.setInt(2, ((Candidato) candidato).getId());					
					
					statement.execute();

					try
					{
						resultado.put("statusOperacao", true);
					} 
					catch (Exception e) 
					{
						connection.rollback();
						resultado.put("statusOperacao", false);
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();

					try
					{
						connection.rollback();
						resultado.put("statusOperacao", false);
					}
					catch (SQLException s) 
					{
						s.printStackTrace();
					}
				} 
				finally
				{
					if (statement != null) 
					{
						try
						{
							statement.close();
						} 
						catch (SQLException s)
						{
							s.printStackTrace();
						}
					}
				}
			}
		}

		return resultado;
	}
}
