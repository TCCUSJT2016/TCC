package com.projeto.think.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.think.Facade.impl.PerfilManager;
import com.projeto.think.Model.AlternativaPerfil;
import com.projeto.think.Model.Perfil;

@Controller
@RequestMapping("/think/perfil")
public class PerfilController {

	PerfilManager manager = new PerfilManager();
	
	@RequestMapping("/consultar.do")
	public String consultar(Perfil perfil) {
		manager.consultar(perfil);
		return "ConsultarPerfil";
	}

	@RequestMapping("/consultarTodos.do")
	public String consultar() {
		manager.consultarTodos();
		return "ConsultarTodosPerfil";
	}
	
	@RequestMapping("/gerarPerfil.do")
	public String gerarPerfil(int idCandidato, ArrayList<AlternativaPerfil> respostas)
	{
		//Verificar melhor forma de passar essas respostas -> to? ** ver com Mauricio
		//Vai passar como o id do usuario que está logado ** ver na integração
		
		manager.gerarPerfil(idCandidato, respostas);
		return "GerarPerfil";
	}
}
