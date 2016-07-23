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

public class AlternativaServiceTeste {
	
	public final int ID_MAX = 17;
	
	IService as;
	IService ps;

	@Before
	public void setUp() throws Exception {
		as = new AlternativaService();
		ps = new PerguntaService();
	}

	//@Ignore
	@Test
	@SuppressWarnings("deprecation")
	public void testCadastrar() {
		IObjectTO perguntaTO = new PerguntaTO();
		IObjectTO alternativaTO = new AlternativaTO();
		
		Alternativa a = null;

		Pergunta p = new Pergunta();

		NivelPergunta np = new NivelPergunta();
		np.setId(1);

		Area ar = new Area();
		ar.setId(1);

		Categoria c = new Categoria();
		c.setId(1);

		Subcategoria sc = new Subcategoria();
		sc.setId(1);

		p.setDescricao("descricao classe AlternativaService");
		p.setPontuacao(1);
		p.setTempoResposta(new Time(00, 00, 01));
		p.setNivelPergunta(np);
		p.setArea(ar);
		p.setCategoria(c);
		p.setSubcategoria(sc);

		perguntaTO.adicionar(p);
		
		int idPergunta = (Integer) ps.cadastrar(perguntaTO).get("idPergunta");

		for (int i = 0; i <= 4; i++) {
			a = new Alternativa();

			a.setDescricao("Alternativa " + (i + 1));
			if (i == 0) {a.setCorreta(true);} else {a.setCorreta(false);}
			a.setPergunta(new Pergunta(idPergunta));

			alternativaTO.adicionar(a);
		}

		String status = (String) as.cadastrar(alternativaTO).get("statusOperacao");

		assertEquals("true", status);
	}

	//@Ignore
	@Test
	public void testConsultar() {
		String s = (String) as.consultar().get("statusOperacao");
		assertEquals("true", s);
	}

	//@Ignore
	@Test
	public void testConsultarPorId() {
		int idBusca = ID_MAX;

		String s = (String) as.consultarPorId(idBusca).get("statusOperacao");
		assertEquals("true", s);
	}

	//@Ignore
	@Test
	public void testAlterar() {
		int idAlteracao = ID_MAX;
		
		IObjectTO alternativaTO = new AlternativaTO();
		Alternativa a = null;

		@SuppressWarnings("unchecked")
		ArrayList<Alternativa> al = (ArrayList<Alternativa>) as.consultarPorId(idAlteracao).get("lista");
		
		for (int i = 0; i < al.size(); i++) {
			a = new Alternativa();
			
			a.setId(al.get(i).getId());
			a.setDescricao("Alternativa" + (i + 1) + " - mod");
			if (i == 4) {a.setCorreta(true);} else {a.setCorreta(false);}
			a.setPergunta(new Pergunta(idAlteracao));

			alternativaTO.adicionar(a);
		}

		String status = (String) as.alterar(alternativaTO).get("statusOperacao");

		assertEquals("true", status);
	}

	//@Ignore
	@Test
	public void testExcluir() {
		int idExclusao = ID_MAX;
		
		IObjectTO alternativaTO = new AlternativaTO();
		Alternativa a = null;
		
		@SuppressWarnings("unchecked")
		ArrayList<Alternativa> al = (ArrayList<Alternativa>) as.consultarPorId(idExclusao).get("lista");

		for (int i = 0; i < al.size(); i++) {
			a = new Alternativa();
			
			a.setId(al.get(i).getId());
			
			alternativaTO.adicionar(a);
		}
		
		String status = (String) as.excluir(alternativaTO).get("statusOperacao");
		
		IObjectTO perguntaTO = new PerguntaTO();
		perguntaTO.adicionar(new Pergunta(idExclusao));
		
		// este metodo pertence a classe PerguntaService.
		ps.excluir(perguntaTO);
		
		assertEquals("true", status);
	}

}
