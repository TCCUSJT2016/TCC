package com.projeto.think.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.projeto.think.Facade.IManager;
import com.projeto.think.Facade.impl.ManterDesafio;
import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;
import com.projeto.think.TO.IObjectTO;
import com.projeto.think.TO.impl.AlternativaTO;
import com.projeto.think.TO.impl.PerguntaTO;

public class DesafioManagerTeste {

	IManager md;

	@Before
	public void setUp() throws Exception {
		md = new ManterDesafio();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCadastrar() {
		Map<String, Object> params = new HashMap<String, Object>();
		boolean b = false;

		IObjectTO toP = new PerguntaTO();
		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta(1);
		Area ar = new Area(1);
		Categoria c = new Categoria(1);
		Subcategoria sc = new Subcategoria(1);

		p.setDescricao("DesafioManager");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 10, 00));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		toP.adicionar(p);
		params.put("perguntas", toP);

		IObjectTO toA = new AlternativaTO();

		for (int i = 0; i < 5; i++) {
			Alternativa a = new Alternativa();
			a.setDescricao("DesafioManager " + (i + 1));
			if (i == 0) {a.setCorreta(true);} else {a.setCorreta(false);}
			a.setPergunta(p);
			toA.adicionar(a);
		}
		params.put("alternativas", toA);

		b = md.cadastrar(params);

		assertEquals(true, b);
	}

	@Ignore
	@Test
	public void testConsultarTodos() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

}
