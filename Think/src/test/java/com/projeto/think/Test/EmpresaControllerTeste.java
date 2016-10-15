package com.projeto.think.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.projeto.think.Controller.EmpresaController;
import com.projeto.think.Model.Empresa;

public class EmpresaControllerTeste {

	EmpresaController empresaController;

	@Before
	public void setUp() throws Exception {
		empresaController = new EmpresaController();
	}

	@Ignore
	@Test
	public void testCadastrar() {

		Empresa empresa = new Empresa();

		empresa.setNomeFantasia("Empresa Teste");
		empresa.setCnpj("44356052870");
		empresa.setLogin("karin");
		empresa.setSenha("123");
		empresa.setTelefone("2703-8377");
		empresa.setContato("Karin");
		empresa.setEmail("karincristina_@hotmail.com");
		empresa.setLogradouro("Rua Clark");
		empresa.setLogradouro_numero("70");
		empresa.setLogradouro_complemento("AP214");
		empresa.setBairro("Mooca");
		empresa.setCep("03167-070");
		empresa.setCidade("São Paulo");
		empresa.setUf("SP");

		String s = empresaController.cadastrar(empresa);

		assertEquals(s, "CadastrarEmpresa");
	}
	
	@Ignore
	@Test
	public void testAlterar() 
	{
		Empresa empresa = new Empresa();

		empresa.setId(12);
		empresa.setNomeFantasia("Geek Trek");
		empresa.setCnpj("44356052870-A");
		empresa.setLogin("karin-A");
		empresa.setSenha("123-A");
		empresa.setTelefone("2703-8377-A");
		empresa.setContato("Karin-A");
		empresa.setEmail("karincristina_@hotmail.com-A");
		empresa.setLogradouro("Rua Clark-A");
		empresa.setLogradouro_numero("70-A");
		empresa.setLogradouro_complemento("AP2-A");
		empresa.setBairro("Mooca-A");
		empresa.setCep("03167-070-A");
		empresa.setCidade("São Paulo-A");
		empresa.setUf("-A");
		
		String s = empresaController.alterar(empresa);

		assertEquals(s, "AlterarEmpresa");
	}
	
	@Ignore
	@Test
	public void testExcluir() 
	{
		Empresa empresa = new Empresa();

		empresa.setId(8);
		
		String s = empresaController.excluir(empresa);

		assertEquals(s, "ExcluirEmpresa");
	}
	
	@Test
	public void testConsultarPorId() {
		
		Empresa empresa = new Empresa();

		empresa.setId(12);
		
		String s = empresaController.consultar(empresa);
		
		assertEquals(s, "ConsultarEmpresa");
	}
	
	@Ignore
	@Test
	public void testeConsultarTodos() {
		
		String s = empresaController.consultar();
		
		assertEquals(s, "ConsultarTodasEmpresas");
		
	}
}
