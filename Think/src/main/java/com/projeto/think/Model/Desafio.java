package com.projeto.think.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Desafio implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Candidato candidato;
	private ArrayList<Alternativa> alternativas;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public ArrayList<Alternativa> getAlternativas() {
		return alternativas;
	}
	
	public void setAlternativas(ArrayList<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void addAlternativa(Alternativa alternativa) {
		alternativas.add(alternativa);
	}
	
	public Alternativa getAlternativa(Alternativa alternativa) {
		return alternativas.get(alternativa.getId());
	}
}
