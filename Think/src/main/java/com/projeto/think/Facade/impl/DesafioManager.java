package com.projeto.think.Facade.impl;

import java.util.ArrayList;

import com.projeto.think.Facade.IManager;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Desafio;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Service.IService;
import com.projeto.think.Service.impl.AlternativaService;
import com.projeto.think.Service.impl.PerguntaService;
import com.projeto.think.TO.impl.DesafioTO;

public class DesafioManager implements IManager {

	IService perguntaService;
	IService alternativaService;

	public DesafioManager() {
		perguntaService = new PerguntaService();
		alternativaService = new AlternativaService();
	}

	public boolean cadastrar(Desafio desafio) {
		boolean statusCadastro = false;
		
		boolean isAlternativaCadastrada = false;
		
		DesafioTO to = new DesafioTO();
		to.adicionar(desafio);
		
		int idPerguntaCadastrada = (Integer) perguntaService.cadastrar(to).get("idPergunta");
		
		if (idPerguntaCadastrada > 0) {
			int quantidadeAlternativa = desafio.getAlternativas().size();
			
			// adiciona a cada alternativa o id da pergunta anteriormente cadastrada
			while(quantidadeAlternativa != 0) {
				Alternativa alternativa = (Alternativa) desafio.getAlternativas().get(quantidadeAlternativa - 1);
				alternativa.setPergunta(new Pergunta(idPerguntaCadastrada));
				quantidadeAlternativa--;
			}
			isAlternativaCadastrada = (Boolean) alternativaService.cadastrar(to).get("statusOperacao");
		}
		
		if(isAlternativaCadastrada) statusCadastro = true;
		
		return statusCadastro;
	}
	
	public boolean alterar(Desafio desafio) {
		boolean statusAlteracao = false;
		
		boolean isPerguntaAlterada = false, isAlternativaAlterada = false;
		
		DesafioTO to = new DesafioTO();
		to.adicionar(desafio);
		
		isPerguntaAlterada = (Boolean) perguntaService.alterar(to).get("statusOperacao");
		isAlternativaAlterada = (Boolean) alternativaService.alterar(to).get("statusOperacao");
		
		if(isPerguntaAlterada == true && isAlternativaAlterada == true) statusAlteracao = true;
		
		return statusAlteracao;
	}

	public boolean excluir(Desafio desafio) {
		boolean statusExclusao = false;
		
		boolean isPerguntaExcluida = false, isAlternativaExcluida = false;
		
		DesafioTO to = new DesafioTO();
		to.adicionar(desafio);
		
		isAlternativaExcluida = (Boolean) alternativaService.excluir(to).get("statusOperacao");
		isPerguntaExcluida = (Boolean) perguntaService.excluir(to).get("statusOperacao");
		
		if(isPerguntaExcluida == true && isAlternativaExcluida == true) statusExclusao = true;
		
		return statusExclusao;
	}
	
	public Desafio consultar(Desafio desafio) {
		Desafio desafioConsultado = new Desafio();
				
		int idPergunta = desafio.getPergunta().getId();
		
		Pergunta p = (Pergunta) perguntaService.consultarPorId(idPergunta).get("pergunta");
		
		// retorna todas as alternativas que pertencem a pergunta retornada acima
		@SuppressWarnings("unchecked")
		ArrayList<Alternativa> alternativas = (ArrayList<Alternativa>) alternativaService.consultarPorId(p.getId()).get("lista");
		
		desafioConsultado.setPergunta(p);
		desafioConsultado.setAlternativas(alternativas);
		
		return desafioConsultado;
	}
	
	
	public DesafioTO consultarTodos() {
		DesafioTO resultadoTO = new DesafioTO();
		
		@SuppressWarnings("unchecked")
		ArrayList<Pergunta> perguntas = (ArrayList<Pergunta>) perguntaService.consultar().get("lista");
		
		int totalPerguntas = perguntas.size();
		
		while(totalPerguntas != 0) {
			Desafio d = new Desafio();
			
			Pergunta p = perguntas.get(totalPerguntas - 1);
			
			@SuppressWarnings("unchecked")
			ArrayList<Alternativa> alternativas = (ArrayList<Alternativa>) alternativaService.consultarPorId(p.getId()).get("lista");
			
			d.setPergunta(p);
			d.setAlternativas(alternativas);
			
			totalPerguntas--;
		}
		
		return resultadoTO;
	}
}
