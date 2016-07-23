package com.projeto.think.Service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.impl.PerguntaDAO;
import com.projeto.think.Service.IService;
import com.projeto.think.TO.IObjectTO;

@Service
public class PerguntaService implements IService {

	private IDAO daoPergunta = null;
	private Map<String, Object> resultado = null;

	public Map<String, Object> cadastrar(IObjectTO objectTO) {

		try {
			resultado = new HashMap<String, Object>();
			daoPergunta = new PerguntaDAO();

			resultado = daoPergunta.cadastrar(objectTO);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public Map<String, Object> consultarPorId(int id) {
		try {
			resultado = new HashMap<String, Object>();
			daoPergunta = new PerguntaDAO();

			resultado = daoPergunta.consultar(id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public Map<String, Object> alterar(IObjectTO objectTO) {

		try {
			resultado = new HashMap<String, Object>();
			daoPergunta = new PerguntaDAO();

			resultado = daoPergunta.alterar(objectTO);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public Map<String, Object> excluir(IObjectTO objectTO) {

		try {
			resultado = new HashMap<String, Object>();
			daoPergunta = new PerguntaDAO();

			resultado = daoPergunta.excluir(objectTO);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}

	public Map<String, Object> consultar() {
		try {
			resultado = new HashMap<String, Object>();
			daoPergunta = new PerguntaDAO();

			resultado = daoPergunta.consultar();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultado;
	}
}
