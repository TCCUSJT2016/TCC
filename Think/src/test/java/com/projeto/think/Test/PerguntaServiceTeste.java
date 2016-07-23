package com.projeto.think.Test;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Area;
import com.projeto.think.Model.Categoria;
import com.projeto.think.Model.NivelPergunta;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Model.Subcategoria;
import com.projeto.think.Service.IService;
import com.projeto.think.Service.impl.AlternativaService;
import com.projeto.think.Service.impl.PerguntaService;
import com.projeto.think.TO.IObjectTO;
import com.projeto.think.TO.impl.AlternativaTO;
import com.projeto.think.TO.impl.PerguntaTO;

public class PerguntaServiceTeste {

	public final int ID_MAX = 13;
	
	IService ps;
	IService as;

	@Before
	public void setUp() throws Exception {
		ps = new PerguntaService();
		as = new AlternativaService();
	}

	//@Ignore
	@Test
	@SuppressWarnings("deprecation")
	public void testCadastrar() {
		IObjectTO perguntaTO = new PerguntaTO();
		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta();
		np.setId(1);

		Area ar = new Area();
		ar.setId(1);

		Categoria c = new Categoria();
		c.setId(1);

		Subcategoria sc = new Subcategoria();
		sc.setId(1);

		p.setDescricao("descricao classe PerguntaServiceTeste");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 10, 00));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		perguntaTO.adicionar(p);
		
		String s = (String) ps.cadastrar(perguntaTO).get("statusOperacao");

		assertEquals("true", s);
	}

	//@Ignore
	@Test
	@SuppressWarnings("deprecation")
	public void testAlterar() {
		int idAlteracao = ID_MAX;
		
		IObjectTO perguntaTO = new PerguntaTO();
		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta();
		np.setId(1);

		Area ar = new Area();
		ar.setId(1);

		Categoria c = new Categoria();
		c.setId(1);

		Subcategoria sc = new Subcategoria();
		sc.setId(1);

		p.setId(idAlteracao);
		p.setDescricao("descricao classe PerguntaServiceTeste - mod");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 10, 00));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		perguntaTO.adicionar(p);
		
		String s = (String) ps.alterar(perguntaTO).get("statusOperacao");

		assertEquals("true", s);
	}

	//@Ignore
	@Test
	public void testConsultar() {
		String s = (String) ps.consultar().get("statusOperacao");
		assertEquals("true", s);
	}
	
	//@Ignore
	@Test
	public void testConsultarPorId() {
		int idBusca = ID_MAX;
		
		String s = (String) ps.consultarPorId(idBusca).get("statusOperacao");
		assertEquals("true", s);
	}
	
	//@Ignore
	@Test
	@SuppressWarnings("deprecation")
	public void testExcluir() {
		int idExclusao = ID_MAX;
		
		IObjectTO alternativaTO = new AlternativaTO();
		Alternativa a = null;
	
		IObjectTO perguntaTO = new PerguntaTO();
		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta();
		np.setId(1);
		np.setDescricao("descricao classe PerguntaServiceTeste - exc");

		Area ar = new Area();
		ar.setId(1);
		ar.setDescricao("descricao classe PerguntaServiceTeste - exc");

		Categoria c = new Categoria();
		c.setId(1);
		c.setDescricao("descricao classe PerguntaServiceTeste - exc");
		c.setArea(ar);

		Subcategoria sc = new Subcategoria();
		sc.setId(1);
		sc.setDescricao("descricao classe PerguntaServiceTeste - exc");
		sc.setCategoria(c);

		p.setId(idExclusao);
		p.setDescricao("descricao classe PerguntaServiceTeste - exc");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 10, 00));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		perguntaTO.adicionar(p);
		
		@SuppressWarnings("unchecked")
		ArrayList<Alternativa> al = (ArrayList<Alternativa>) as.consultarPorId(p.getId()).get("lista");

		for (int i = 0; i < al.size(); i++) {
			a = new Alternativa();
			
			a.setId(al.get(i).getId());
			a.setDescricao(al.get(i).getDescricao());
			a.setCorreta(al.get(i).isCorreta());
			a.setPergunta(al.get(i).getPergunta());
			
			alternativaTO.adicionar(a);
		}

		// este metodo pertence a classe AlternativaService.
		as.excluir(alternativaTO);
		
		String s = (String) ps.excluir(perguntaTO).get("statusOperacao");

		assertEquals("true", s);
	}
}
