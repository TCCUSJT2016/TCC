package com.projeto.think.Controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.think.Facade.impl.DesafioManager;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Desafio;
import com.projeto.think.Model.Pergunta;

@Controller
@RequestMapping("/desafio")
public class DesafioController {

	DesafioManager manager = new DesafioManager();
	
	@RequestMapping("/cadastrar.do")
	public String cadastrar(Desafio desafio) {
		manager.cadastrar(desafio);
		return "CadastrarDesafio";
	}
	
	@RequestMapping("/alterar.do")
	public String alterar(Desafio desafio) {
		manager.alterar(desafio);
		return "AlterarDesafio";
	}
	
	@RequestMapping("/excluir.do")
	public String excluir(Desafio desafio) {
		manager.excluir(desafio);
		return "ExcluirDesafio";
	}
	
	@RequestMapping("/consultar.do")
	public String consultar(Desafio desafio) {
		manager.consultar(desafio);
		return "ConsultarDesafio";
	}
	
	@RequestMapping("/consultarTodos.do")
	public String consultar() {
		manager.consultarTodos();
		return "ConsultarTodosDesafios";
	}
	
	@RequestMapping("/realizar.do")
	public ModelAndView realizar(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("/desafios/realizar");
		
		HttpSession session = request.getSession();
		Desafio desafio = (Desafio) session.getAttribute("desafio");
		
		Map<String, Object> resultado = new HashMap<String, Object>();
		resultado = manager.aceitaDesafio(desafio);
		
		Time tempoTotalResposta = (Time) resultado.get("tempoTotalResposta");
		ArrayList<Alternativa> alternativas = (ArrayList<Alternativa>) resultado.get("alternativas");
		
		mv.addObject("tempoTotalResposta", tempoTotalResposta);
		mv.addObject("alternativas", alternativas);
		
		return mv;
	}
	
}
