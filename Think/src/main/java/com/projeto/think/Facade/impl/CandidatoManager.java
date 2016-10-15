package com.projeto.think.Facade.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

import com.projeto.think.Common.Enum.PerfilEnum;
import com.projeto.think.Facade.IManager;
import com.projeto.think.Model.Candidato;
import com.projeto.think.Model.Cargo;
import com.projeto.think.Model.Departamento;
import com.projeto.think.Model.Empresa;
import com.projeto.think.Model.NivelCandidato;
import com.projeto.think.Service.impl.UsuarioService;
import com.projeto.think.TO.impl.CandidatoTO;
import com.projeto.think.TO.impl.EmpresaTO;
import com.projeto.think.Service.impl.CandidatoService;
import com.projeto.think.Service.impl.CargoService;
import com.projeto.think.Service.impl.DepartamentoService;
import com.projeto.think.Service.impl.EmpresaService;
import com.projeto.think.Service.impl.NivelCandidatoService;

@Component
public class CandidatoManager implements IManager
{
	private UsuarioService usuarioService = new UsuarioService();
	private CandidatoService candidatoService = new CandidatoService();
	private DepartamentoService departamentoService = new DepartamentoService();
	private CargoService cargoService = new CargoService();
	private NivelCandidatoService nivelCandidatoService = new NivelCandidatoService();
	private EmpresaService empresaService = new EmpresaService();
	
	private Logger logger = Logger.getLogger(CandidatoManager.class);
	
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object consultar(int id) {
		return null;
	}

	public boolean cadastrar(Map<String, Object> params) {

		logger.info("[Projeto THINK]: Cadastrar Candidato - Iniciando o processo de cadastro...");
		
		boolean cadastroUsuarioEfetuado = false;
		
		String login = (String) params.get("login");
		
		
		try
		{
			logger.info("[Projeto THINK]: Cadastrar Candidato - Identificando se o candidato já existe na base...");
			
			// Evitar usuários com o mesmo login
			if(! usuarioService.getUsuario(login))
			{
				logger.info("[Projeto THINK]: Cadastrar Candidato - Candidato não encontrado na base...");
				logger.info("[Projeto THINK]: Cadastrar Candidato - Recuperando dependências do candidato...");
				
				Departamento departamento = null;
				Cargo cargo = null;
				NivelCandidato nivelCandidato = null;
				Empresa empresa = null;
				
				try
				{
					logger.info("[Projeto THINK]: Cadastrar Candidato - Recuperando departamento...");
					int idDepartamento = Integer.parseInt((String) params.get("idDepartamento"));
					departamento = (Departamento) departamentoService.consultarPorId(idDepartamento);
					
					
					logger.info("[Projeto THINK]: Cadastrar Candidato - Recuperando cargo...");
					int idCargo = Integer.parseInt((String) params.get("idCargo"));
					cargo = (Cargo) cargoService.consultarPorId(idCargo);
				
					
					logger.info("[Projeto THINK]: Cadastrar Candidato - Recuperando nível...");
					int idNivel = Integer.parseInt((String)params.get("nivelCandidato"));
					nivelCandidato = (NivelCandidato) nivelCandidatoService.consultarPorId(idNivel);
					
					logger.info("[Projeto THINK]: Cadastrar Candidato - Recuperando empresa...");
					int idEmpresa = Integer.parseInt((String) params.get("idEmpresa"));
					empresa = (Empresa) empresaService.consultarPorId(idEmpresa);
					
					logger.info("[Projeto THINK]: Cadastrar Candidato - Dependências recuperadas com sucesso...");
				}
				catch(Exception e1)
				{
					logger.info("[Projeto THINK]: Cadastrar Candidato - Falha na recuperação das dependências...");
					e1.printStackTrace();
				}
				
				
				String senha 			= (String) params.get("senha");
				String nomeCompleto		= (String) params.get("nome");
				Calendar dataAdmissao 	= (Calendar)params.get("dataAdmissao");
				boolean statusAtividade = Boolean.parseBoolean((String) params.get("statusAtividade"));
				Calendar dataNascimento = (Calendar) params.get("dataNascimento");
				char genero 			= ((String) params.get("genero")).charAt(0);
				String grauEscolaridade = (String) params.get("grauEscolaridade");
				
				
				
				String senhaCripto = usuarioService.criptografar(senha);
				
				Candidato candidato = new Candidato(0, login, senhaCripto, nomeCompleto, dataAdmissao,
										 				statusAtividade, dataNascimento, genero,
										 				grauEscolaridade, cargo, empresa, null, departamento, nivelCandidato);
			

				
				try
				{
					logger.info("[Projeto THINK]: Cadastrar Candidato - Cadastrando candidato...");
					
					
					Map<String,Object> resultado = usuarioService.cadastrar(candidato);
					cadastroUsuarioEfetuado = Boolean.parseBoolean((String)resultado.get("statusOperacao")); 
					
					//TODO
					if(cadastroUsuarioEfetuado)
					{
						
					}
					else
					{
						
					}
					
					logger.info("[Projeto THINK]: Cadastrar Candidato - Candidato cadastrado com sucesso...");
					
					
				}
				catch(Exception e2)
				{
					logger.info("[Projeto THINK]: Cadastrar Candidato - Falha no cadastro do candidato...");
					e2.printStackTrace();
				}				
			}
			else
			{
				logger.info("[Projeto THINK]: Cadastrar Candidato - Candidato já cadastrado. Não é possível cadastrá-lo");
				cadastroUsuarioEfetuado = false;
			}
					
		}
		catch(Exception e)
		{
			logger.info("[Projeto THINK]: Cadastrar Candidato - Falha no acesso a base de dados...");
			e.printStackTrace();
		}
		
		return cadastroUsuarioEfetuado;
	}

	public boolean alterar(List<Object> object) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluir(List<Object> object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean alterarPerfil(int id, PerfilEnum perfil)
	{
		boolean statusAlteracao = false;
		
		Candidato model = new Candidato();
		model.setId(id);
		
		CandidatoTO objectTO = new CandidatoTO();		
		objectTO.adicionar(model);
		
		statusAlteracao = (Boolean) candidatoService.alterarPerfil(objectTO, perfil).get("statusOperacao");

		return statusAlteracao;
	}

}
