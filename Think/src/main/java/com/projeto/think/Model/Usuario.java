package com.projeto.think.Model;

import java.util.Calendar;

/**
 * @author Cleberson Costa
 * 
 * @descrition Esta classe abstrata representa a estrutura de usuário.
 */
public abstract class Usuario {
	
	protected 	int 		id;
	protected 	String 		login;
	protected 	String 		senha;
	protected 	String 		nomeCompleto;
	protected 	Calendar 	dataAdmissao;
	protected 	boolean 	statusAtividade;
	protected 	Calendar 	dataNascimento;
	protected 	char 		genero;
	protected 	String 		grauEscolaridade;
	protected 	Cargo 		cargo;
	protected	Empresa		empresa;
		
	public Usuario(){
		this.setId(0);
		this.setLogin(null);
		this.setSenha(null);
		this.setNomeCompleto(null);
		this.setDataAdmissao(null);
		this.setStatusAtividade(false);
		this.setDataNascimento(null);
		this.setGenero(' ');
		this.setGrauEscolaridade(null);
		this.setCargo(null);
		this.setEmpresa(null);
	}
	
	public Usuario(int id, String login, String senha, String nomeCompleto, Calendar dataAdmissao,
				   boolean statusAtividade, Calendar dataNascimento, char genero, String grauEscolaridade, Cargo cargo, Empresa empresa) {
		
		this.setId(id);
		this.setLogin(login);
		this.setSenha(senha);
		this.setNomeCompleto(nomeCompleto);
		this.setDataAdmissao(dataAdmissao);
		this.setStatusAtividade(statusAtividade);
		this.setDataNascimento(dataNascimento);
		this.setGenero(genero);
		this.setGrauEscolaridade(grauEscolaridade);
		this.setCargo(cargo);
		this.setEmpresa(empresa);
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public boolean getStatusAtividade() {
		return statusAtividade;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public char getGenero() {
		return genero;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setStatusAtividade(boolean statusAtividade) {
		this.statusAtividade = statusAtividade;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
