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
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;
import com.projeto.think.TO.IObjectTO;

@Repository
public class AlternativaDAO extends DatabaseConstants implements IDAO {

	Map<String, Object> resultado = null;
	List<Object> lista = null;

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	ConnectionFactory connectionFactory = null;

	private static final String TABLE_NAME_ALTERNATIVA = "TB_ALTERNATIVA";
	private static final String COLUMN_ID_ALTERNATIVA = "IDALTERNATIVA_PK";
	private static final String COLUMN_DESCRICAO = "DESCRICAO";
	private static final String COLUMN_CORRETA = "CORRETA";
	private static final String COLUMN_IDPERGUNTA_FK = "IDPERGUNTA_FK";
	

	public Map<String, Object> consultar(int id) {

		String fields[] = this.getFieldsTableAlternativa();

		String query = super.getSelectOne(TABLE_NAME_ALTERNATIVA, fields, COLUMN_IDPERGUNTA_FK);

		try {
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			try {
				rs = statement.executeQuery();

				while (rs.next()) {
					Alternativa a = new Alternativa();

					a.setId(rs.getInt(COLUMN_ID_ALTERNATIVA));
					a.setDescricao(rs.getString(COLUMN_DESCRICAO));
					a.setCorreta(rs.getBoolean(COLUMN_CORRETA));
					a.setPergunta(new Pergunta());

					lista.add(a);
				}
				resultado.put("lista", lista);
				resultado.put("statusOperacao", "true");

			} catch (Exception e) {
				connection.rollback();
				resultado.put("statusOperacao", "false");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				resultado.put("statusOperacao", "false");
				
			} catch (SQLException s) {
				s.printStackTrace();
				
			}
			
		} finally {
			if (statement != null) {
				
				try {
					statement.close();
					
				} catch (SQLException s) {
					s.printStackTrace();
					
				}
			}
		}
		
		return resultado;
	}

	public Map<String, Object> consultar() {

		String query = super.getSelectAllQuery(TABLE_NAME_ALTERNATIVA);

		try {
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			try {
				rs = statement.executeQuery();

				while (rs.next()) {
					Alternativa a = new Alternativa();

					a.setDescricao(rs.getString(COLUMN_DESCRICAO));
					a.setCorreta(rs.getBoolean(COLUMN_CORRETA));
					a.setPergunta(new Pergunta(rs.getInt(COLUMN_IDPERGUNTA_FK), null, 0, null, null, null, null, null));
					
					lista.add(a);
				}
				resultado.put("lista", lista);
				resultado.put("statusOperacao", "true");
				
			} catch (Exception e) {
				connection.rollback();
				resultado.put("statusOperacao", "false");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				resultado.put("statusOperacao", "false");
				
			} catch (SQLException s) {
				s.printStackTrace();
				
			}
			
		} finally {
			if (statement != null) {
				
				try {
					statement.close();
					
				} catch (SQLException s) {
					s.printStackTrace();
					
				}
			}
		}
		
		return resultado;
	}

	public Map<String, Object> cadastrar(IObjectTO objectTO) {

		String fields[] = this.getFieldsTableAlternativaSemId();

		String query = super.getInsertQuery(TABLE_NAME_ALTERNATIVA, fields);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Alternativa a = (Alternativa) objectTO.consultar().get(i);

			if (a instanceof Alternativa) {

				try {
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

					statement.setString(1, a.getDescricao());
					statement.setBoolean(2, a.isCorreta());
					statement.setInt(3, a.getPergunta().getId());

					try {
						statement.execute();
						
						int idPergunta = 0;
						rs = statement.getGeneratedKeys();
						
						while(rs.next()) {
							idPergunta = rs.getInt(1);
						}
						
						resultado.put("idPergunta", idPergunta);
						resultado.put("statusOperacao", "true");

					} catch (Exception e) {
						connection.rollback();
						resultado.put("statusOperacao", "false");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
					try {
						connection.rollback();
						resultado.put("statusOperacao", "false");
						
					} catch (SQLException s) {
						s.printStackTrace();
						
					}
					
				} finally {
					if (statement != null) {
						
						try {
							statement.close();
							
						} catch (SQLException s) {
							s.printStackTrace();
							
						}
					}
				}
			}
		}
		
		return resultado;
	}

	public Map<String, Object> alterar(IObjectTO objectTO) {

		String fields[] = this.getFieldsTableAlternativaSemId();

		String query = super.getUpdateQuery(TABLE_NAME_ALTERNATIVA, fields, COLUMN_ID_ALTERNATIVA);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Alternativa a = (Alternativa) objectTO.consultar().get(i);

			if (a instanceof Alternativa) {

				try {
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setString(1, a.getDescricao());
					statement.setBoolean(2, a.isCorreta());
					statement.setInt(3, a.getPergunta().getId());

					statement.setInt(4, a.getId());

					try {
						statement.execute();
						
						resultado.put("statusOperacao", "true");
						
					} catch (Exception e) {
						connection.rollback();
						resultado.put("statusOperacao", "false");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
					try {
						connection.rollback();
						resultado.put("statusOperacao", "false");
						
					} catch (SQLException s) {
						s.printStackTrace();
						
					}
					
				} finally {
					if (statement != null) {
						
						try {
							statement.close();
							
						} catch (SQLException s) {
							s.printStackTrace();
							
						}
					}
				}
			}
		}
		return resultado;
	}

	public Map<String, Object> excluir(IObjectTO objectTO) {

		String query = super.getDeleteQuery(TABLE_NAME_ALTERNATIVA, COLUMN_ID_ALTERNATIVA);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Alternativa a = (Alternativa) objectTO.consultar().get(i);

			if (a instanceof Alternativa) {

				try {
					resultado = new HashMap<String, Object>();
					
					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setInt(1, a.getId());
					
					try {
						statement.execute();
						
						resultado.put("statusOperacao", "true");
						
					} catch (Exception e) {
						connection.rollback();
						resultado.put("statusOperacao", "false");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
					try {
						connection.rollback();
						resultado.put("statusOperacao", "false");
						
					} catch (SQLException s) {
						s.printStackTrace();
					}
					
				} finally {
					if (statement != null) {
						try {
							statement.close();
							
						} catch (SQLException s) {
							s.printStackTrace();
							
						}
					}
				}
			}
		}
		return resultado;
	}

	private String[] getFieldsTableAlternativaSemId() {
		String fields[] = new String[3];

		fields[0] = COLUMN_DESCRICAO;
		fields[1] = COLUMN_CORRETA;
		fields[2] = COLUMN_IDPERGUNTA_FK;

		return fields;
	}

	private String[] getFieldsTableAlternativa() {
		String fields[] = new String[4];

		fields[0] = COLUMN_ID_ALTERNATIVA;
		fields[1] = COLUMN_DESCRICAO;
		fields[2] = COLUMN_CORRETA;
		fields[3] = COLUMN_IDPERGUNTA_FK;

		return fields;
	}
}
