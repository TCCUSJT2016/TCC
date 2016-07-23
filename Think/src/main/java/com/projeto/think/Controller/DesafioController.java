package com.projeto.think.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.think.Facade.IManager;
import com.projeto.think.Facade.impl.ManterDesafio;
import com.projeto.think.TO.IObjectTO;

@Controller
@RequestMapping("/think/desafio")
public class DesafioController {

	IManager manager = new ManterDesafio();
	
	@RequestMapping("/cadastrar.do")
	public String novo(IObjectTO pTO, IObjectTO aTO) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("perguntas", pTO);
		params.put("alternativas", aTO);
		
		manager.cadastrar(params);
		
		return "CadastrarDesafio";
	}
}
