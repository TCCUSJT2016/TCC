package com.projeto.think.Repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Perfil;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;
import com.projeto.think.TO.IObjectTO;

@Repository
public class PerfilDAO extends DatabaseConstants implements IDAO {

	Map<String, Object> resultado = null;
	List<Object> lista = null;

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	ConnectionFactory connectionFactory = null;

	private static final String TABLE_NAME_PERFIL = "TB_PERFIL";
	private static final String COLUMN_ID_PERFIL = "IDPERFIL_PK";
	private static final String COLUMN_TIPO_PERFIL = "TIPOPERFIL";

	public Map<String, Object> consultar(int id) 
	{
		String fields[] = this.getFieldsTablePerfil();
		
		String query = super.getSelectOne(TABLE_NAME_PERFIL, fields, COLUMN_ID_PERFIL);
		
		try 
		{
			resultado = new HashMap<String, Object>();
			
			Perfil perfil = null;
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			rs = statement.executeQuery();
			try 
			{
				while (rs.next())
				{
					perfil = new Perfil();

					perfil.setId(rs.getInt(COLUMN_ID_PERFIL));
					perfil.setTipoPerfil(rs.getString(COLUMN_TIPO_PERFIL));
				}
				
				resultado.put("perfil", perfil);
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

		return resultado;
	}
	
	public Map<String, Object> consultar()
	{
		String query = super.getSelectAllQuery(TABLE_NAME_PERFIL);
		
		try 
		{
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			
			rs = statement.executeQuery();
			try 
			{
				Perfil perfil = null;				
				while (rs.next())
				{
					perfil = new Perfil();
					
					perfil.setId(rs.getInt(COLUMN_ID_PERFIL));
					perfil.setTipoPerfil(rs.getString(COLUMN_TIPO_PERFIL));
					
					lista.add(perfil);
				}
				
				resultado.put("lista", lista);
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

		return resultado;
	}

	private String[] getFieldsTablePerfilSemId()
	{
		String fields[] = new String[1];

		fields[0] = COLUMN_TIPO_PERFIL;
		
		return fields;
	}
	
	private String[] getFieldsTablePerfil()
	{
		String fields[] = new String[2];

		fields[0] = COLUMN_ID_PERFIL;
		fields[1] = COLUMN_TIPO_PERFIL;
		return fields;
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
