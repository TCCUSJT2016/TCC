package com.projeto.think.Facade.impl;

import java.util.Map;

import com.projeto.think.Facade.IManager;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Service.IService;
import com.projeto.think.Service.impl.AlternativaService;
import com.projeto.think.Service.impl.PerguntaService;
import com.projeto.think.TO.IObjectTO;
import com.projeto.think.TO.impl.AlternativaTO;
import com.projeto.think.TO.impl.PerguntaTO;

public class ManterDesafio implements IManager {

	IService perguntaService;
	IService alternativaService;
	
	public ManterDesafio() {
		perguntaService = new PerguntaService();
		alternativaService = new AlternativaService();
	}
	
	public boolean cadastrar(Map<String, Object> params) {
		boolean sucesso = false;
		
		IObjectTO perguntaTO = new PerguntaTO();
		IObjectTO alternativaTO = new AlternativaTO();
		
		perguntaTO = (IObjectTO) params.get("perguntas");
		alternativaTO = (IObjectTO) params.get("alternativas");

		int idPergunta = (Integer) perguntaService.cadastrar(perguntaTO).get("idPergunta");
		
		// looping necessario para injetar o id da pergunta na alternativa respectiva
		for(int i = 0; i < alternativaTO.consultar().size(); i++) {
			Alternativa a = (Alternativa) alternativaTO.consultar().get(i);
			a.setPergunta(new Pergunta(idPergunta));
		}
		
		String status = (String) alternativaService.cadastrar(alternativaTO).get("statusOperacao");
		
		if(status.equals("true")) sucesso = true;
		
		return sucesso;
	}

}
