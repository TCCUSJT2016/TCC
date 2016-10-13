package com.projeto.think.Facade.impl;

import java.util.ArrayList;

import com.projeto.think.Facade.IManager;
import com.projeto.think.Model.Empresa;
import com.projeto.think.Service.IService;
import com.projeto.think.Service.impl.EmpresaService;
import com.projeto.think.TO.impl.EmpresaTO;

public class EmpresaManager implements IManager
{
	IService empresaService;

	public EmpresaManager()
	{
		empresaService = new EmpresaService();
	}

	public boolean cadastrar(Empresa empresa)
	{
		boolean statusCadastro = false;

		EmpresaTO to = new EmpresaTO();
		to.adicionar(empresa);
		
		statusCadastro = (Boolean) empresaService.cadastrar(to).get("statusOperacao");

		return statusCadastro;
	}
	
	
	public boolean alterar(Empresa empresa)
	{
		boolean statusAlteracao = false;

		EmpresaTO to = new EmpresaTO();
		to.adicionar(empresa);
		
		statusAlteracao = (Boolean) empresaService.alterar(to).get("statusOperacao");

		return statusAlteracao;
	}

	
	public boolean excluir(Empresa empresa)
	{
		boolean statusExclusao = false;
		
		EmpresaTO to = new EmpresaTO();
		to.adicionar(empresa);
		
		statusExclusao = (Boolean) empresaService.excluir(to).get("statusOperacao");
		return statusExclusao;
	}

	
	public Empresa consultar(Empresa empresa) 
	{
		Empresa empresaConsultado = new Empresa();
		
		empresaConsultado = (Empresa)empresaService.consultarPorId(empresa.getId()).get("empresa");
		
		return empresaConsultado;
	}

	public ArrayList<Empresa> consultarTodos() 
	{
		ArrayList<Empresa> empresasConsultadas = (ArrayList<Empresa>) empresaService.consultar().get("lista");
			
		return empresasConsultadas;
	}
}
