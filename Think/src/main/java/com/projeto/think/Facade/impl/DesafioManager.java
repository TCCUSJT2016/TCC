package com.projeto.think.Facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.think.Facade.IManager;

public class DesafioManager implements IManager {

	@RequestMapping("/cadastrar.do")
	public boolean cadastrar(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@RequestMapping(value = "/consultarTodos.do", method = RequestMethod.GET)
	public List<Object> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/consultar.do", method = RequestMethod.GET)
	public Object consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@RequestMapping("/alterar.do")
	public boolean alterar(List<Object> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@RequestMapping("/excluir.do")
	public boolean excluir(List<Object> object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
