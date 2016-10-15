package com.projeto.think.Facade.impl;

import java.util.ArrayList;

import com.projeto.think.Common.Enum.PerfilEnum;
import com.projeto.think.Facade.IManager;
import com.projeto.think.Model.AlternativaPerfil;
import com.projeto.think.Model.Perfil;
import com.projeto.think.Model.PerfilGenerator;
import com.projeto.think.Service.IService;
import com.projeto.think.Service.impl.PerfilService;

public class PerfilManager implements IManager
{
	IService perfilService;

	public PerfilManager()
	{
		perfilService = new PerfilService();		
	}	
	
	public Perfil consultar(Perfil perfil) 
	{
		Perfil perfilConsultado = new Perfil();
		
		perfilConsultado = (Perfil)perfilService.consultarPorId(perfil.getId()).get("perfil");
		
		return perfilConsultado;
	}

	public ArrayList<Perfil> consultarTodos()
	{
		ArrayList<Perfil> perfilConsultados = (ArrayList<Perfil>) perfilService.consultar().get("lista");
			
		return perfilConsultados;
	}
	
	public void gerarPerfil(int idCandidato, ArrayList<AlternativaPerfil> respostas)
	{
		PerfilGenerator perfilGenerator = new PerfilGenerator();
		
		PerfilEnum perfil = perfilGenerator.gerarPerfil(respostas);
		
		CandidatoManager manager = new CandidatoManager();
		
		manager.alterarPerfil(idCandidato, perfil);
	}
}
