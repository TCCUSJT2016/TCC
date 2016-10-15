package com.projeto.think.Model;

import java.util.ArrayList;

import com.projeto.think.Common.Enum.AlternativaEnum;
import com.projeto.think.Common.Enum.PerfilEnum;

public class PerfilGenerator
{
	public PerfilEnum gerarPerfil(ArrayList<AlternativaPerfil> respostas)
	{
		ArrayList<AlternativaPerfil> bloco1 = separarBloco(respostas, 1);
		ArrayList<AlternativaPerfil> bloco2 = separarBloco(respostas, 2);
		ArrayList<AlternativaPerfil> bloco3 = separarBloco(respostas, 3);
		ArrayList<AlternativaPerfil> bloco4 = separarBloco(respostas, 4);
		ArrayList<AlternativaPerfil> bloco5 = separarBloco(respostas, 5);
		ArrayList<AlternativaPerfil> bloco6 = separarBloco(respostas, 6);
		ArrayList<AlternativaPerfil> bloco7 = separarBloco(respostas, 7);
		
		String perfil = "";
		AlternativaEnum letraSuperior;
		ArrayList<AlternativaPerfil> blocoAux = new ArrayList<AlternativaPerfil>();
		
		//Primeira Letra		
		letraSuperior = gerarLetra(bloco1);
		
		if(letraSuperior == AlternativaEnum.ALTERNATIVAA)
			perfil += "E";
		else
			perfil += "I";
		
		//Segunda Letra
		blocoAux = new ArrayList<AlternativaPerfil>();
		blocoAux.addAll(bloco2);
		blocoAux.addAll(bloco3);
		
		letraSuperior = gerarLetra(blocoAux);		
		
		if(letraSuperior == AlternativaEnum.ALTERNATIVAA)
			perfil += "S";
		else
			perfil += "N";
		
		//Terceira Letra
		blocoAux = new ArrayList<AlternativaPerfil>();
		blocoAux.addAll(bloco4);
		blocoAux.addAll(bloco5);
		
		letraSuperior = gerarLetra(blocoAux);		
		
		if(letraSuperior == AlternativaEnum.ALTERNATIVAA)
			perfil += "T";
		else
			perfil += "F";
		
		//Quarta Letra
		blocoAux = new ArrayList<AlternativaPerfil>();
		blocoAux.addAll(bloco6);
		blocoAux.addAll(bloco7);
		
		letraSuperior = gerarLetra(blocoAux);		
		
		if(letraSuperior == AlternativaEnum.ALTERNATIVAA)
			perfil += "J";
		else
			perfil += "P";
		
		return PerfilEnum.valueOf(perfil);
	}
	
	public AlternativaEnum gerarLetra(ArrayList<AlternativaPerfil> respostas)
	{
		int respostasA = 0, respostasB = 0;
		
		for (AlternativaPerfil alternativaPerfil : respostas)
		{
			if (alternativaPerfil.getSelecionada() == AlternativaEnum.ALTERNATIVAA)
				respostasA++;
			else
				respostasB++;
		}
		
		return respostasA >= respostasB ? AlternativaEnum.ALTERNATIVAA : AlternativaEnum.ALTERNATIVAB;
	}
	
	public ArrayList<AlternativaPerfil> separarBloco(ArrayList<AlternativaPerfil> respostas, int first)
	{
		ArrayList<AlternativaPerfil> bloco = new ArrayList<AlternativaPerfil>();
		
		bloco.add(respostas.get(first));
		
		for (int i = first; i <= 70; i+=7)
		{
			bloco.add(respostas.get(i));
		}		
		return bloco;
	}
}
