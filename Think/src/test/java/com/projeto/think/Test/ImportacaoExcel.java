package com.projeto.think.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.projeto.think.Model.Alternativa;
import com.projeto.think.Model.Pergunta;
import com.projeto.think.Repository.IDAO;
import com.projeto.think.Repository.impl.AlternativaDAO;
import com.projeto.think.Repository.impl.PerguntaDAO;
import com.projeto.think.TO.IObjectTO;
import com.projeto.think.TO.impl.AlternativaTO;
import com.projeto.think.TO.impl.PerguntaTO;
import com.projeto.think.xls.IExcel;
import com.projeto.think.xls.impl.AlternativaExcel;
import com.projeto.think.xls.impl.PerguntaExcel;

public class ImportacaoExcel {

	IExcel pe;
	IExcel ae;
	
	@Before
	public void setUp() throws Exception {
		pe = new PerguntaExcel();
		ae = new AlternativaExcel();
	}

	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		String statusEsperarado[] = {"true", "true"};
		String status[] = new String[2];
		
		IDAO daoPergunta = new PerguntaDAO();
		IDAO daoAlternativa = new AlternativaDAO();
		
		IObjectTO perguntaTO = new PerguntaTO();
		IObjectTO alternativaTO = new AlternativaTO();
		
		String diretorio = "/Users/ClebersonCosta/Desktop/pasta.xlsx";
		
		@SuppressWarnings("unchecked")
		ArrayList<Pergunta> listaPerguntas = (ArrayList<Pergunta>) pe.lerArquivoExcel(diretorio).get("lista");
		
		for(int i = 0; i < listaPerguntas.size(); i++) {
			perguntaTO.adicionar(listaPerguntas.get(i));
		}
		
		status[0] = (String) daoPergunta.cadastrar(perguntaTO).get("statusOperacao");
		
		@SuppressWarnings("unchecked")
		ArrayList<Alternativa> listaAlternativas = (ArrayList<Alternativa>) ae.lerArquivoExcel(diretorio).get("lista");
		
		for(int i = 0; i < listaAlternativas.size(); i++) {
			alternativaTO.adicionar(listaAlternativas.get(i));
		}
		
		status[1] = (String) daoAlternativa.cadastrar(alternativaTO).get("statusOperacao");
		
		assertEquals(statusEsperarado, status);
	}

}
