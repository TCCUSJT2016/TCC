package com.projeto.think.Test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.projeto.think.Controller.DesafioController;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.Desafio;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;

public class DesafioControllerTeste {

	DesafioController dc;

	@Before
	public void setUp() throws Exception {
		dc = new DesafioController();
	}

	@Ignore
	@Test
	public void testCadastrar() {
		
		Pergunta pergunta = new Pergunta();
		pergunta.setDescricao("DesafioControllerTeste");
		pergunta.setPontuacao(100);
		pergunta.setTempoResposta(new Time(00,05,00));
		pergunta.setNivelPergunta(new NivelPergunta(1));
		pergunta.setArea(new Area(1));
		pergunta.setCategoria(new Categoria(1));
		pergunta.setSubcategoria(new Subcategoria(1));
		
		Alternativa alternativa = new Alternativa();
		alternativa.setDescricao("DesafioControllerTeste - Alternativa 1");
		alternativa.setCorreta(true);
		alternativa.setPergunta(pergunta);
		
		ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(alternativa);
		
		Desafio desafio = new Desafio();
		desafio.setPergunta(pergunta);
		desafio.setAlternativas(alternativas);
		
		String s = dc.cadastrar(desafio);
		
		assertEquals(s, "CadastrarDesafio");
	}

	@Ignore
	@Test
	public void testAlterar() {

		Pergunta pergunta = new Pergunta();
		pergunta.setId(51);
		pergunta.setDescricao("Modificado - DesafioControllerTeste");
		pergunta.setPontuacao(100);
		pergunta.setTempoResposta(new Time(00,05,00));
		pergunta.setNivelPergunta(new NivelPergunta(1));
		pergunta.setArea(new Area(1));
		pergunta.setCategoria(new Categoria(1));
		pergunta.setSubcategoria(new Subcategoria(1));
		
		Alternativa alternativa = new Alternativa();
		alternativa.setId(94);
		alternativa.setDescricao("Alternativa Modificada");
		alternativa.setCorreta(false);
		alternativa.setPergunta(pergunta);
		
		ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(alternativa);
		
		Desafio desafio = new Desafio();
		desafio.setPergunta(pergunta);
		desafio.setAlternativas(alternativas);
		
		String s = dc.alterar(desafio);
		
		assertEquals(s, "AlterarDesafio");
	}
	
	@Ignore
	@Test
	public void testExcluir() {

		Pergunta pergunta = new Pergunta();
		pergunta.setId(50);
		
		Alternativa alternativa = new Alternativa();
		alternativa.setId(93);
		
		ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(alternativa);
		
		Desafio desafio = new Desafio();
		desafio.setPergunta(pergunta);
		desafio.setAlternativas(alternativas);
		
		String s = dc.excluir(desafio);
		
		assertEquals(s, "ExcluirDesafio");
	}
	
	@Ignore
	@Test
	public void testConsultarPorId() {
		
		Pergunta pergunta = new Pergunta();
		pergunta.setId(51);
		
		Desafio desafio = new Desafio();
		desafio.setPergunta(pergunta);
		
		String s = dc.consultar(desafio);
		
		assertEquals(s, "ConsultarDesafio");
	}
	
	@Test
	public void testeConsultarTodos() {
		
		String s = dc.consultar();
		
		assertEquals(s, "ConsultarTodosDesafios");
		
	}
}
