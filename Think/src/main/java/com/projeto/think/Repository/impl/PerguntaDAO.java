package com.projeto.think.Repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.common.DatabaseConstants;
import com.projeto.think.TO.IObjectTO;

@Repository
public class PerguntaDAO extends DatabaseConstants implements IDAO {

	Map<String, Object> resultado = null;
	List<Object> lista = null;

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	ConnectionFactory connectionFactory = null;

	private static final String TABLE_NAME_PERGUNTA = "TB_PERGUNTA";
	private static final String COLUMN_ID_PERGUNTA = "IDPERGUNTA_PK";
	private static final String COLUMN_DESCRICAO = "DESCRICAO";
	private static final String COLUMN_PONTUACAO = "PONTUCAO";
	private static final String COLUMN_TEMPO_RESPOSTA = "TEMPORESPOSTA";
	private static final String COLUMN_ID_NIVEL_PERGUNTA = "IDNIVELPERGUNTA_FK";
	private static final String COLUMN_ID_AREA = "IDAREA_FK";
	private static final String COLUMN_ID_CATEGORIA = "IDCATEGORIA_FK";
	private static final String COLUMN_ID_SUBCATEGORIA = "IDSUBCATEGORIA_FK";

	public Map<String, Object> consultar(int id) {

		String fields[] = this.getFieldsTablePergunta();

		String query = super.getSelectOne(TABLE_NAME_PERGUNTA, fields, COLUMN_ID_PERGUNTA);

		try {
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);

			try {
				rs = statement.executeQuery();

				while (rs.next()) {
					Pergunta p = new Pergunta();

					p.setId(rs.getInt(COLUMN_ID_PERGUNTA));
					p.setDescricao(rs.getString(COLUMN_DESCRICAO));
					p.setPontuacao(rs.getInt(COLUMN_PONTUACAO));
					p.setTempoResposta(new Time(rs.getLong(COLUMN_TEMPO_RESPOSTA)));
					p.setNivelPergunta(new NivelPergunta(rs.getInt(COLUMN_ID_NIVEL_PERGUNTA), null));
					p.setArea(new Area(rs.getInt(COLUMN_ID_AREA), null));
					p.setCategoria(new Categoria(rs.getInt(COLUMN_ID_CATEGORIA), null, new Area(rs.getInt(COLUMN_ID_AREA), null)));
					p.setSubcategoria(new Subcategoria(rs.getInt(COLUMN_ID_SUBCATEGORIA), null, new Categoria(rs.getInt(COLUMN_ID_CATEGORIA), null, new Area(rs.getInt(COLUMN_ID_AREA), null))));

					lista.add(p);
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

		String query = super.getSelectAllQuery(TABLE_NAME_PERGUNTA);

		try {
			resultado = new HashMap<String, Object>();
			lista = new ArrayList<Object>();

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			try {
				rs = statement.executeQuery();

				while (rs.next()) {
					Pergunta p = new Pergunta();

					p.setId(rs.getInt(COLUMN_ID_PERGUNTA));
					p.setDescricao(rs.getString(COLUMN_DESCRICAO));
					p.setPontuacao(rs.getInt(COLUMN_PONTUACAO));
					p.setTempoResposta(new Time(rs.getLong(COLUMN_TEMPO_RESPOSTA)));
					p.setNivelPergunta(new NivelPergunta(rs.getInt(COLUMN_ID_NIVEL_PERGUNTA), null));
					p.setArea(new Area(rs.getInt(COLUMN_ID_AREA), null));
					p.setCategoria(new Categoria(rs.getInt(COLUMN_ID_CATEGORIA), null, new Area(rs.getInt(COLUMN_ID_AREA), null)));
					p.setSubcategoria(new Subcategoria(rs.getInt(COLUMN_ID_SUBCATEGORIA), null, new Categoria(rs.getInt(COLUMN_ID_CATEGORIA), null, new Area(rs.getInt(COLUMN_ID_AREA), null))));

					lista.add(p);
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

		String fields[] = this.getFieldsTablePerguntaSemId();

		String query = super.getInsertQuery(TABLE_NAME_PERGUNTA, fields);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Pergunta p = (Pergunta) objectTO.consultar().get(i);

			if (p instanceof Pergunta) {

				try {
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

					statement.setString(1, p.getDescricao());
					statement.setInt(2, p.getPontuacao());
					statement.setTime(3, p.getTempoResposta());
					statement.setInt(4, p.getNivelPergunta().getId());
					statement.setInt(5, p.getArea().getId());
					statement.setInt(6, p.getCategoria().getId());
					statement.setInt(7, p.getSubcategoria().getId());

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

		String fields[] = this.getFieldsTablePerguntaSemId();

		String query = super.getUpdateQuery(TABLE_NAME_PERGUNTA, fields, COLUMN_ID_PERGUNTA);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Pergunta p = (Pergunta) objectTO.consultar().get(i);

			if (p instanceof Pergunta) {

				try {
					resultado = new HashMap<String, Object>();

					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setString(1, p.getDescricao());
					statement.setInt(2, p.getPontuacao());
					statement.setTime(3, p.getTempoResposta());
					statement.setInt(4, p.getNivelPergunta().getId());
					statement.setInt(5, p.getArea().getId());
					statement.setInt(6, p.getCategoria().getId());
					statement.setInt(7, p.getSubcategoria().getId());

					statement.setInt(8, p.getId());

					try {
						statement.execute();
						
						int idPergunta = this.getIdPergunta(p.getId());
						
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

	public Map<String, Object> excluir(IObjectTO objectTO) {

		String query = super.getDeleteQuery(TABLE_NAME_PERGUNTA, COLUMN_ID_PERGUNTA);

		for (int i = 0; i < objectTO.consultar().size(); i++) {

			Pergunta p = (Pergunta) objectTO.consultar().get(i);

			if (p instanceof Pergunta) {

				try {
					resultado = new HashMap<String, Object>();
					
					connection = ConnectionFactory.getConnection();
					statement = connection.prepareStatement(query);

					statement.setInt(1, p.getId());
					
					try {
						statement.execute();
						
						int idPergunta = this.getIdPergunta(p.getId());
						
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

	private String[] getFieldsTablePerguntaSemId() {
		String fields[] = new String[7];

		fields[0] = COLUMN_DESCRICAO;
		fields[1] = COLUMN_PONTUACAO;
		fields[2] = COLUMN_TEMPO_RESPOSTA;
		fields[3] = COLUMN_ID_NIVEL_PERGUNTA;
		fields[4] = COLUMN_ID_AREA;
		fields[5] = COLUMN_ID_CATEGORIA;
		fields[6] = COLUMN_ID_SUBCATEGORIA;

		return fields;
	}

	private String[] getFieldsTablePergunta() {
		String fields[] = new String[8];

		fields[0] = COLUMN_ID_PERGUNTA;
		fields[1] = COLUMN_DESCRICAO;
		fields[2] = COLUMN_PONTUACAO;
		fields[3] = COLUMN_TEMPO_RESPOSTA;
		fields[4] = COLUMN_ID_NIVEL_PERGUNTA;
		fields[5] = COLUMN_ID_AREA;
		fields[6] = COLUMN_ID_CATEGORIA;
		fields[7] = COLUMN_ID_SUBCATEGORIA;

		return fields;
	}

	private int getIdPergunta(int id) {

		String fields[] = this.getFieldsTablePergunta();
		
		String query = super.getSelectOne(TABLE_NAME_PERGUNTA, fields, COLUMN_ID_PERGUNTA);

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			
			try { 
				rs = statement.executeQuery();
	
				while (rs.next()) {
					return rs.getInt(COLUMN_ID_PERGUNTA);
				}
				
			} catch (Exception e) {
				connection.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				
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
		return 0;
	}
}