package com.projeto.think.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.think.Facade.impl.EmpresaManager;
import com.projeto.think.Model.Empresa;

@Controller
@RequestMapping("/think/empresa")
public class EmpresaController {

	EmpresaManager manager = new EmpresaManager();

	@RequestMapping("/cadastrar.do")
	public String cadastrar(Empresa empresa) {
		manager.cadastrar(empresa);
		return "CadastrarEmpresa";
	}

	@RequestMapping("/alterar.do")
	public String alterar(Empresa empresa) {
		manager.alterar(empresa);
		return "AlterarEmpresa";
	}

	@RequestMapping("/excluir.do")
	public String excluir(Empresa empresa) {
		manager.excluir(empresa);
		return "ExcluirEmpresa";
	}

	@RequestMapping("/consultar.do")
	public String consultar(Empresa empresa) {
		manager.consultar(empresa);
		return "ConsultarEmpresa";
	}

	@RequestMapping("/consultarTodos.do")
	public String consultar() {
		manager.consultarTodos();
		return "ConsultarTodasEmpresas";
	}
}
