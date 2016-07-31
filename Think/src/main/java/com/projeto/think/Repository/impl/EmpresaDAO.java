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

import com.mysql.jdbc.Statement;
import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Empresa;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;
import com.projeto.think.TO.IObjectTO;

@Repository
public class EmpresaDAO extends DatabaseConstants implements IDAO {

	Map<String, Object> resultado = null;
	List<Object> lista = null;

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	ConnectionFactory connectionFactory = null;

	private static final String TABLE_NAME_EMPRESA = "TB_EMPRESA";
	private static final String COLUMN_ID_EMPRESA = "IDEMPRASA_PK";
	private static final String COLUMN_NOMEFANTASIA = "NOMEFANTASIA";
	private static final String COLUMN_CNPJ = "CNPJ";
	private static final String COLUMN_LOGIN = "LOGIN";
	private static final String COLUMN_SENHA = "SENHA";
	private static final String COLUMN_TELEFONE = "TELEFONE";
	private static final String COLUMN_CONTATO = "CONTATO";
	private static final String COLUMN_EMAIL = "EMAIL";
	private static final String COLUMN_LOGRADOURO = "LOGRADOURO";
	private static final String COLUMN_NUMERO_LOGRADOURO = "NUMERO_LOGRADOURO";
	private static final String COLUMN_COMPLEMENTO_LOGRADOURO = "COMPLEMENTO_LOGRADOURO";
	private static final String COLUMN_BAIRRO = "BAIRRO";
	private static final String COLUMN_CEP = "CEP";
	private static final String COLUMN_CIDADE = "CIDADE";
	private static final String COLUMN_UF = "UF";

	public Map<String, Object> cadastrar(IObjectTO objectTO) 
	{
		for (Object empresa : objectTO.consultar())
		{
			if (empresa instanceof Empresa)
			{
				String fields[] = this.getFieldsTableEmpresaSemId();

				String query = super.getInsertQuery(TABLE_NAME_EMPRESA, fields);

				try
				{
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

					statement.setString(1, ((Empresa) empresa).getNomeFantasia());
					statement.setString(2, ((Empresa) empresa).getCnpj());
					statement.setString(3, ((Empresa) empresa).getLogin());
					statement.setString(4, ((Empresa) empresa).getSenha());
					statement.setString(5, ((Empresa) empresa).getTelefone());
					statement.setString(6, ((Empresa) empresa).getContato());
					statement.setString(7, ((Empresa) empresa).getEmail());
					statement.setString(8, ((Empresa) empresa).getLogradouro());
					statement.setString(9, ((Empresa) empresa).getLogradouro_numero());
					statement.setString(10, ((Empresa) empresa).getLogradouro_complemento());
					statement.setString(11, ((Empresa) empresa).getBairro());
					statement.setString(12, ((Empresa) empresa).getCep());
					statement.setString(13, ((Empresa) empresa).getCidade());
					statement.setString(14, ((Empresa) empresa).getUf());					
					
					statement.execute();

					try
					{

						int idEmpresa = 0;
						rs = statement.getGeneratedKeys();

						while (rs.next())
						{
							idEmpresa = rs.getInt(1);
						}

						resultado.put("idEmpresa", idEmpresa);
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
	
	public Map<String, Object> alterar(IObjectTO objectTO) 
	{
		for (Object empresa : objectTO.consultar())
		{
			if (empresa instanceof Empresa)
			{
				String fields[] = this.getFieldsTableEmpresaSemId();

				String query = super.getUpdateQuery(TABLE_NAME_EMPRESA, fields, COLUMN_ID_EMPRESA);

				try
				{
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setString(1, ((Empresa) empresa).getNomeFantasia());
					statement.setString(2, ((Empresa) empresa).getCnpj());
					statement.setString(3, ((Empresa) empresa).getLogin());
					statement.setString(4, ((Empresa) empresa).getSenha());
					statement.setString(5, ((Empresa) empresa).getTelefone());
					statement.setString(6, ((Empresa) empresa).getContato());
					statement.setString(7, ((Empresa) empresa).getEmail());
					statement.setString(8, ((Empresa) empresa).getLogradouro());
					statement.setString(9, ((Empresa) empresa).getLogradouro_numero());
					statement.setString(10, ((Empresa) empresa).getLogradouro_complemento());
					statement.setString(11, ((Empresa) empresa).getBairro());
					statement.setString(12, ((Empresa) empresa).getCep());
					statement.setString(13, ((Empresa) empresa).getCidade());
					statement.setString(14, ((Empresa) empresa).getUf());
					
					statement.setInt(15, ((Empresa) empresa).getId());
					
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
	
	public Map<String, Object> excluir(IObjectTO objectTO)
	{
		for (Object empresa : objectTO.consultar())
		{
			if (empresa instanceof Empresa)
			{
				String query = super.getDeleteQuery(TABLE_NAME_EMPRESA, COLUMN_ID_EMPRESA);

				try
				{
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setInt(1, ((Empresa) empresa).getId());
					
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
	
	public Map<String, Object> consultar(int id) 
	{
		String fields[] = this.getFieldsTableEmpresa();
		
		String query = super.getSelectOne(TABLE_NAME_EMPRESA, fields, COLUMN_ID_EMPRESA);
		
		try 
		{
			resultado = new HashMap<String, Object>();
			
			Empresa empresa = null;
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			rs = statement.executeQuery();
			try 
			{
				while (rs.next())
				{
					empresa = new Empresa();

					empresa.setId(rs.getInt(COLUMN_ID_EMPRESA));
					empresa.setNomeFantasia(rs.getString(COLUMN_NOMEFANTASIA));
					empresa.setCnpj(rs.getString(COLUMN_CNPJ));
					empresa.setLogin(rs.getString(COLUMN_LOGIN));
					empresa.setSenha(rs.getString(COLUMN_SENHA));
					empresa.setTelefone(rs.getString(COLUMN_TELEFONE));
					empresa.setContato(rs.getString(COLUMN_CONTATO));
					empresa.setEmail(rs.getString(COLUMN_EMAIL));
					empresa.setLogradouro(rs.getString(COLUMN_LOGRADOURO));
					empresa.setLogradouro_numero(rs.getString(COLUMN_NUMERO_LOGRADOURO));
					empresa.setLogradouro_complemento(rs.getString(COLUMN_COMPLEMENTO_LOGRADOURO));
					empresa.setBairro(rs.getString(COLUMN_BAIRRO));
					empresa.setCep(rs.getString(COLUMN_CEP));
					empresa.setCidade(rs.getString(COLUMN_CIDADE));
					empresa.setUf(rs.getString(COLUMN_UF));
				}
				
				resultado.put("empresa", empresa);
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
		String query = super.getSelectAllQuery(TABLE_NAME_EMPRESA);
		
		try 
		{
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			
			rs = statement.executeQuery();
			try 
			{
				Empresa empresa = null;				
				while (rs.next())
				{
					empresa = new Empresa();

					empresa.setId(rs.getInt(COLUMN_ID_EMPRESA));
					empresa.setNomeFantasia(rs.getString(COLUMN_NOMEFANTASIA));
					empresa.setCnpj(rs.getString(COLUMN_CNPJ));
					empresa.setLogin(rs.getString(COLUMN_LOGIN));
					empresa.setSenha(rs.getString(COLUMN_SENHA));
					empresa.setTelefone(rs.getString(COLUMN_TELEFONE));
					empresa.setContato(rs.getString(COLUMN_CONTATO));
					empresa.setEmail(rs.getString(COLUMN_EMAIL));
					empresa.setLogradouro(rs.getString(COLUMN_LOGRADOURO));
					empresa.setLogradouro_numero(rs.getString(COLUMN_NUMERO_LOGRADOURO));
					empresa.setLogradouro_complemento(rs.getString(COLUMN_COMPLEMENTO_LOGRADOURO));
					empresa.setBairro(rs.getString(COLUMN_BAIRRO));
					empresa.setCep(rs.getString(COLUMN_CEP));
					empresa.setCidade(rs.getString(COLUMN_CIDADE));
					empresa.setUf(rs.getString(COLUMN_UF));
					
					lista.add(empresa);
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

	private String[] getFieldsTableEmpresaSemId()
	{
		String fields[] = new String[14];

		fields[0] = COLUMN_NOMEFANTASIA;
		fields[1] = COLUMN_CNPJ;
		fields[2] = COLUMN_LOGIN;
		fields[3] = COLUMN_SENHA;
		fields[4] = COLUMN_TELEFONE;
		fields[5] = COLUMN_CONTATO;
		fields[6] = COLUMN_EMAIL;
		fields[7] = COLUMN_LOGRADOURO;
		fields[8] = COLUMN_NUMERO_LOGRADOURO;
		fields[9] = COLUMN_COMPLEMENTO_LOGRADOURO;
		fields[10] = COLUMN_BAIRRO;
		fields[11] = COLUMN_CEP;
		fields[12] = COLUMN_CIDADE;
		fields[13] = COLUMN_UF;

		return fields;
	}
	
	private String[] getFieldsTableEmpresa()
	{
		String fields[] = new String[15];

		fields[0] = COLUMN_ID_EMPRESA;
		fields[1] = COLUMN_NOMEFANTASIA;
		fields[2] = COLUMN_CNPJ;
		fields[3] = COLUMN_LOGIN;
		fields[4] = COLUMN_SENHA;
		fields[5] = COLUMN_TELEFONE;
		fields[6] = COLUMN_CONTATO;
		fields[7] = COLUMN_EMAIL;
		fields[8] = COLUMN_LOGRADOURO;
		fields[9] = COLUMN_NUMERO_LOGRADOURO;
		fields[10] = COLUMN_COMPLEMENTO_LOGRADOURO;
		fields[11] = COLUMN_BAIRRO;
		fields[12] = COLUMN_CEP;
		fields[13] = COLUMN_CIDADE;
		fields[14] = COLUMN_UF;

		return fields;
	}
}
