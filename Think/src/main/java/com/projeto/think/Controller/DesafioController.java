package com.projeto.think.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.think.Facade.impl.DesafioManager;
import com.projeto.think.Model.Desafio;

@Controller
@RequestMapping("/think/desafio")
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
}
