package com.projeto.think.Model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Cleberson Costa
 *
 * @description Esta classe estende um usuário e mantém os dados de um Candidato.
 */
public class Candidato extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Perfil perfil;
	private Departamento departamento;
	private NivelCandidato nivelCandidato;

	public Candidato() {
		super();
		this.setPerfil(null);
		this.setDepartamento(null);
	}

	public Candidato(int id, String login, String senha, String nomeCompleto, 
						Calendar dataAdmissao, boolean statusAtividade,
						Calendar dataNascimento, char genero, String grauEscolaridade,
						Cargo cargo, Empresa empresa, Perfil perfil, Departamento departamento, NivelCandidato nivelCandidato) {
		
		super(id, login, senha, nomeCompleto, dataAdmissao, statusAtividade, dataNascimento, genero, grauEscolaridade, cargo, empresa);
		this.setPerfil(perfil);
		this.setDepartamento(departamento);
		this.setNivelCandidato(nivelCandidato);
	}

	// Getters
	public Perfil getPerfil() {
		return perfil;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public NivelCandidato getNivelCandidato() {
		return nivelCandidato;
	}

	// Setters
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setNivelCandidato(NivelCandidato nivelCandidato) {
		this.nivelCandidato = nivelCandidato;
	}
}