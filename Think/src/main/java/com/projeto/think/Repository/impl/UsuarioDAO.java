package com.projeto.think.Repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Candidato;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;

@Repository
public class UsuarioDAO extends DatabaseConstants implements IDAO {

	private static final String TABLE_NAME_USUARIO			= "TB_USUARIO";
	
	private static final String COLUMN_LOGIN				= "LOGIN";
	private static final String COLUMN_SENHA				= "SENHA";
	private static final String COLUMN_NOME_COMPLETO 		= "NOMECOMPLETO";
	private static final String COLUMN_DATA_ADMISSAO		= "DATAADMISSAO";
	private static final String COLUMN_STATUS_ATIVIDADE 	= "STATUSATIVIDADE";
	private static final String COLUMN_DATA_NASCIMENTO		= "DATANASCIMENTO";
	private static final String COLUMN_GENERO				= "GENERO";
	private static final String COLUMN_GRAU_ESCOLARIDADE	= "GRAUESCOLARIDADE";
	private static final String	COLUMN_ID_CARGO				= "IDCARGO";
	private static final String COLUMN_ID_EMPRESA			= "IDEMPRESA";
	
	
	@Autowired
	ConnectionFactory connectionFactory;
	
	public Map<String, Object> consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String, Object> consultar() {
		
		return null;
	}

	public Map<String, Object> cadastrar(Object object)
	{
		List<Object> candidato = new ArrayList<Object>();
		candidato.add(object);
		
		return this.cadastrar(candidato);
	}
	
	public Map<String, Object> cadastrar(List<Object> objects)
	{

		Map<String, Object> resultado = new HashMap<String, Object>();
		
		for(Object candidato : objects )
		{
			if(candidato instanceof Candidato)
			{
				String fields[] = this.getFieldsTableUsuario();
				
				String query = super.getInsertQuery(TABLE_NAME_USUARIO, fields);
				
				Connection connection = null;
				PreparedStatement statement = null;
				try
				{
					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);
					
					
					//CRIA UM NOVO USUÁRIO
					statement.setString (1, ((Candidato) candidato).getLogin());
					statement.setString (2, ((Candidato) candidato).getSenha());
					statement.setString (3, ((Candidato) candidato).getNomeCompleto());
					statement.setDate   (4, new Date(((Candidato) candidato).getDataAdmissao().getTimeInMillis()));
					statement.setBoolean(5, ((Candidato) candidato).getStatusAtividade());
					statement.setDate   (6, new Date(((Candidato) candidato).getDataNascimento().getTimeInMillis()));
					statement.setString (7, String.valueOf(((Candidato) candidato).getGenero()));
					statement.setString (8, ((Candidato) candidato).getGrauEscolaridade());
					statement.setInt    (9, ((Candidato) candidato).getCargo().getId());
					statement.setInt    (10, ((Candidato) candidato).getEmpresa().getId());
					
					statement.executeQuery(query);
					
					try
					{
						//RECUPERAR O ID(AUTO INCREMENT) através do login
						int idUsuario = this.getIdUsuario(((Candidato) candidato).getLogin());
						
						resultado.put("idUsuario", idUsuario);
						resultado.put("statusOperacao", "true");
					}
					catch(Exception e)
					{
						connection.rollback();
						resultado.put("statusOperacao", "false");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
					try
					{
						connection.rollback();
						resultado.put("statusOperacao", "false");
					}
					catch (SQLException e1)
					{
						System.out.print(e1.getStackTrace());
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
						catch (SQLException e1)
						{
							System.out.print(e1.getStackTrace());
						}
					}
				}
			}
		}
		
		return null;
	}

	public Map<String, Object> alterar(Object object)
	{
		List<Object> candidato = new ArrayList<Object>();
		candidato.add(object);
		
		return this.alterar(candidato);
	}
	
	public Map<String, Object> alterar(List<Object> object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> excluir(Object object)
	{
		List<Object> candidato = new ArrayList<Object>();
		candidato.add(object);
		
		return this.excluir(candidato);
	}
	
	public Map<String, Object> excluir(List<Object> objects){
		
		return null;
	}
	
	
	private String[] getFieldsTableUsuario()
	{
		String fields[] = new String[10];
		
		fields[0] = COLUMN_LOGIN;
		fields[1] = COLUMN_SENHA;
		fields[2] = COLUMN_NOME_COMPLETO;
		fields[3] = COLUMN_DATA_ADMISSAO;
		fields[4] = COLUMN_STATUS_ATIVIDADE; 
		fields[5] = COLUMN_DATA_NASCIMENTO;
		fields[6] = COLUMN_GENERO;
		fields[7] = COLUMN_GRAU_ESCOLARIDADE;
		fields[8] = COLUMN_ID_CARGO;		
		fields[9] = COLUMN_ID_EMPRESA;
		
		return fields;
	}
	
	
	private int getIdUsuario(String login)
	{
		
		return 0;
	}
}
