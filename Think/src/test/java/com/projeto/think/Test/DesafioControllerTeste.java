package com.projeto.think.Test;

import static org.junit.Assert.assertEquals;

import java.sql.Time;

import org.junit.Before;
import org.junit.Test;

import com.projeto.think.Controller.DesafioController;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;
import com.projeto.think.TO.IObjectTO;
import com.projeto.think.TO.impl.AlternativaTO;
import com.projeto.think.TO.impl.PerguntaTO;

public class DesafioControllerTeste {

	DesafioController dc;

	@Before
	public void setUp() throws Exception {
		dc = new DesafioController();
	}

	@Test
	@SuppressWarnings("deprecation")
	public void testNovo() {
		IObjectTO pTO = new PerguntaTO();
		IObjectTO aTO = new AlternativaTO();
		
		// cadastrando pergunta
		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta(1);
		Area ar = new Area(1);
		Categoria c = new Categoria(1);
		Subcategoria sc = new Subcategoria(1);

		p.setDescricao("DesafioController");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 10, 00));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		pTO.adicionar(p);

		// cadastrando 5 alternativas
		for (int i = 0; i < 5; i++) {
			Alternativa a = new Alternativa();
			a.setDescricao("DesafioController " + (i + 1));
			if (i == 0) {a.setCorreta(true);} else {a.setCorreta(false);}
			a.setPergunta(p);
			aTO.adicionar(a);
		}

		String s = dc.novo(pTO, aTO);
		
		assertEquals("CadastrarDesafio", s);
	}

}
