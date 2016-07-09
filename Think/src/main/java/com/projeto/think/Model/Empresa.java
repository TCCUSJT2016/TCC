package com.projeto.think.Model;

import java.io.Serializable;

public class Empresa implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nomeFantasia;
	private String cnpj;
	private String login;
	private String senha;
	private String telefone;
	private String contato;
	private String email;
	private String logradouro;
	private String logradouro_numero;
	private String logradouro_complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getLogradouro_numero() {
		return logradouro_numero;
	}
	
	public void setLogradouro_numero(String logradouro_numero) {
		this.logradouro_numero = logradouro_numero;
	}
	
	public String getLogradouro_complemento() {
		return logradouro_complemento;
	}
	
	public void setLogradouro_complemento(String logradouro_complemento) {
		this.logradouro_complemento = logradouro_complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
}
