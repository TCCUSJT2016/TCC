package com.projeto.think.Test;

import org.junit.Test;

import com.projeto.think.Controller.CandidatoController;

public class ThinkTest {

	boolean cadastrarCandidato = false;
	boolean consultarCandidato = false;
	boolean alterarCandidato = false;
	boolean excluirCandidato = false;
	
	
	@Test
	public String test()
	{
		
		if(cadastrarCandidato)
		{
			String login = "Teste1";
			String senha = "Senha1";
			int idDepartamento = 1;
			int idSuperiorImediato = 1;
			int idCargo = 1;
			String nome = "User1";
			int diaAdmisssao = 1;
			int mesAdmisssao = 1;
			int anoAdmisssao = 2016;
			int statusAtividade = 1;
			int diaNascimento = 1;
			int mesNascimento = 1;
			int anoNascimento = 1;
			String genero = "M";
			String grauEscolaridade = "Superior";
			int nivelCandidato = 1;
			int idEmpresa = 1;
			
			CandidatoController controller = new CandidatoController();
			
			String result = controller.cadastrarCandidato(
									login, senha, idDepartamento, idSuperiorImediato,
									idCargo, nome, diaAdmisssao, mesAdmisssao, anoAdmisssao,
									statusAtividade, diaNascimento, mesNascimento, anoNascimento,
									genero, grauEscolaridade, nivelCandidato, idEmpresa);

			System.out.println(result);
			return result;
		
		}
		else if(consultarCandidato)
		{
			
		}
		else if(alterarCandidato)
		{
			
		}
		else if(excluirCandidato)
		{
			
		}
		
		return null;
	}
}
