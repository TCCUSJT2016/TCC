package com.projeto.think.Repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Desafio;
import com.projeto.think.Model.Pergunta;

@Repository
public class DesafioDAO {
	
	Map<String, Object> resultado = null;
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	
	ConnectionFactory connectionFactory = null;
	
	public Map<String, Object> aceitaDesafio(Desafio desafio) {
		
		String query = null;
		int pontuacaoTotal = 0;
		Time tempoTotalResposta = null;
		
		resultado = new HashMap<String, Object>();
		
		try {
			
			// efetua a soma do tempo total para responder ao desafio
			query = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(tempoResposta))) AS 'tempo_total_desafio' "
				  + "FROM tb_desafio_pergunta_asn INNER JOIN tb_pergunta "
				  + "ON tb_desafio_pergunta_asn.idPergunta_FK = tb_pergunta.idPergunta_PK WHERE idDesafio_FK = ?";
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, desafio.getId());
			
			rs = statement.executeQuery();
				
			while (rs.next()) {
				tempoTotalResposta = rs.getTime(1);
			}
			
			// efetua a soma da pontuacao total para o desafio
			query = "SELECT SUM(pontucao) AS 'pontuacao_total_desafio' "
				  + "FROM tb_desafio_pergunta_asn INNER JOIN tb_pergunta "
				  + "ON tb_desafio_pergunta_asn.idPergunta_FK = tb_pergunta.idPergunta_PK WHERE idDesafio_FK = ?";
			
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, desafio.getId());
			
			rs = statement.executeQuery();
				
			while (rs.next()) {
				pontuacaoTotal = rs.getInt(1);
			}
			
			query = "INSERT INTO tb_dados_desafio (desafioAceito, duracao, pontuacaoTotal, idDesafio_FK) VALUES (?, ?, ?, ?)";
			
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, 1);
			statement.setTime(2, tempoTotalResposta);
			statement.setInt(3, pontuacaoTotal);
			statement.setInt(4, desafio.getId());
			
			statement.execute();
			
//			query = "SELECT t2.idPergunta_PK, t2.descricao "
//				  + "FROM tb_desafio_pergunta_asn AS t1 INNER JOIN tb_pergunta AS t2 "
//				  + "ON t1.idPergunta_FK = t2.idPergunta_PK "
//				  + "INNER JOIN tb_alternativa AS t3 ON t2.idPergunta_PK = t3.idAlternativa_PK "
//				  + "WHERE idDesafio_FK = ?";
//			
//			statement = connection.prepareStatement(query);
//			
//			statement.setInt(1, desafio.getId());
//			
//			rs = statement.executeQuery();
//			
//			ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
//			
//			while(rs.next()) {
//			
//				Pergunta p = new Pergunta();
//				p.setId(rs.getInt(1));
//				p.setDescricao(rs.getString(2));
//				
//				perguntas.add(p);
//			}
			
			query = "SELECT t3.idAlternativa_PK, t3.descricao, t2.idPergunta_PK, t2.descricao "
					  + "FROM tb_desafio_pergunta_asn AS t1 INNER JOIN tb_pergunta AS t2 "
					  + "ON t1.idPergunta_FK = t2.idPergunta_PK "
					  + "INNER JOIN tb_alternativa AS t3 ON t2.idPergunta_PK = t3.idAlternativa_PK "
					  + "WHERE idDesafio_FK = ?";
				
			statement = connection.prepareStatement(query);
				
			statement.setInt(1, desafio.getId());
				
			rs = statement.executeQuery();
				
			ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
			
			while(rs.next()) {
					
				Alternativa a = new Alternativa();
				a.setId(rs.getInt(1));
				a.setDescricao(rs.getString(2));
				
				Pergunta p = new Pergunta();
				p.setId(rs.getInt(3));
				p.setDescricao(rs.getString(4));
				
				a.setPergunta(p);
				
				alternativas.add(a);
			}
			
			resultado.put("statusOperacao", true);
			resultado.put("tempoTotalResposta", tempoTotalResposta);
			resultado.put("alternativas", alternativas);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				resultado.put("statusOperacao", false);
				
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
	
	
	
}
