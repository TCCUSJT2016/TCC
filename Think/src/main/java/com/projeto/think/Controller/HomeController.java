package com.projeto.think.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.think.Factory.ConnectionFactory;
import com.projeto.think.Model.Desafio;

@Controller
@RequestMapping(value = "/")
public class HomeController
{

	/**
	 * Atende as requisi��es GET feitas � raiz da aplica��o.
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
	
	// apenas para teste
	@RequestMapping("teste.do")
	public ModelAndView abc(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		Desafio desafio = new Desafio();
		desafio.setId(5);
		
		session.setAttribute("desafio", desafio);
		
		ModelAndView mv = new ModelAndView("/layout/home");
		
		return mv;
	}
}