package com.projeto.think.Controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.think.Facade.IManager;


@Controller
@RequestMapping("think/candidato")
public class CandidatoController
{
	@Autowired
	private IManager manager;
	
	@RequestMapping("/consultar.do")
	public String consultarCandidato( @RequestParam("id")	 				int id,
								   	  @RequestParam("nome") 				String nome,
								   	  @RequestParam("cargo") 				String cargo,
								   	  @RequestParam("departamento") 		String departamento,
								   	  @RequestParam("statusAtividade")	 	boolean statusAtividade)
	{
		return null;
	}
	
	
	
	@RequestMapping("/cadastrar.do")
	public String cadastrarCandidato( @RequestParam("login")				 String login,
									  @RequestParam("senha")				 String senha,
									  @RequestParam("departamento")			 int idDepartamento,
									  @RequestParam("superiorImediato")		 int idSuperiorImediato,
									  @RequestParam("cargo")				 int idCargo,
									  @RequestParam("nome")					 String nome,
									  @RequestParam("diaAdmissao") 		 	 int diaAdmisssao,
									  @RequestParam("mesAdmissao") 		 	 int mesAdmisssao,
									  @RequestParam("anoAdmissao") 		 	 int anoAdmisssao,
									  @RequestParam("statusAtividade") 		 int statusAtividade,
									  @RequestParam("diaNascimento") 		 int diaNascimento,
									  @RequestParam("mesNascimento") 		 int mesNascimento,
									  @RequestParam("anoNascimento") 		 int anoNascimento,
									  @RequestParam("genero") 				 String genero,
									  @RequestParam("grauEscolaridade") 	 String grauEscolaridade,
									  @RequestParam("idNivelCandidato")		 int nivelCandidato,
									  @RequestParam("idEmpresa")			 int idEmpresa)
	{
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar calendarAdmissao = Calendar.getInstance();
		Calendar calendarNascimento = Calendar.getInstance();
		
		if(validarParametro(login))
			params.put("login", login.trim());
		
		if(validarParametro(senha))
			params.put("senha", senha.trim());
		
		params.put("idDepartamento", idDepartamento);
		params.put("idSuperiorImediato", idSuperiorImediato);
		params.put("idCargo", idCargo);
		
		if(validarParametro(nome))
			params.put("nome", nome);
		
		calendarAdmissao.set(anoAdmisssao, mesAdmisssao, diaAdmisssao);
		params.put("dataAdmissao", calendarAdmissao);
		
		
		params.put("statusAtividade", (statusAtividade == 0 ? true : false));
		
		calendarNascimento.set(anoNascimento, mesNascimento, diaNascimento);
		params.put("dataNascimento", calendarNascimento);
		
		if(validarParametro(genero))
			params.put("genero", genero);
		
		if(validarParametro(grauEscolaridade))
			params.put("grauEscolaridade", grauEscolaridade);
		
		params.put("nivelCandidato", nivelCandidato);
		
		params.put("idEmpresa", idEmpresa);
		
		try
		{
			boolean sucesso = manager.cadastrar(params);
			
			if(sucesso)
			{
				return "Sucesso"; //TODO
			}
			else
			{
				return "Falha"; //TODO
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/atualizar.do")
	public String atualizarCandidato( @RequestParam("nome") 				 String nome,
									  @RequestParam("dataAdmissao") 		 String dataAdmisssao,
									  @RequestParam("statusAtividade") 		 String statusAtividade,
									  @RequestParam("dataNascimento") 		 String dataNascimento,
									  @RequestParam("genero") 				 String genero,
									  @RequestParam("grauEscolaridade") 	 String grauEscolaridade)
	{
		
		Map<String, Object> campos = new HashMap<String, Object>();
		
		
		if( validarParametro(nome) )
			campos.put("nomeCompleto", nome);
		
		if( validarParametro(dataAdmisssao) )
			campos.put("dataAdmisssao", dataAdmisssao);

		if( validarParametro(statusAtividade) )
			campos.put("statusAtividade", statusAtividade);
		
		if( validarParametro(dataNascimento) )
			campos.put("statusAtividade", statusAtividade);
		
		if( validarParametro(genero) )
			campos.put("genero", genero);
		
		if( validarParametro(grauEscolaridade) )
			campos.put("grauEscolaridade", grauEscolaridade);
		
		
		return "hub";
	}
	
	
	
	public boolean validarParametro(String parametro)
	{
		if(parametro.trim().equals("") || parametro.equals(null))
		{
			//TODO
			return false;
		}
		
		return true;
	}
	
}
