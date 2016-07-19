package com.projeto.think.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.think.Factory.ConnectionFactory;

@Controller
@RequestMapping(value = "/")
public class HomeController
{

	/**
	 * Atende as requisições GET feitas à raiz da aplicação.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("mensagemTeste", "Teste!");
		return "index";
	}
	
	@RequestMapping("cadastrarEmpresa")
	public String cadastrarEmpresa(Model model)
	{
		return "cadastrarEmpresa";
	}
	
	@RequestMapping("consultarEmpresa")
	public String consultarEmpresa(Model model)
	{
		return "consultarEmpresa";
	}
	
	@RequestMapping("testeConexao")
	public String testConexao(Model model)
	{
		ConnectionFactory.printURL();
		return "index";
	}
}