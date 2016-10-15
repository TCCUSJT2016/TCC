package com.projeto.think.Common.Enum;

public enum PerfilEnum 
{
	//Analistas
	INTJ("INTJ"),
	INTP("INTP"),
	ENTJ("ENTJ"),
	ENTP("ENTP"),
	
	//Diplomatas
	INFJ("INFJ"),
	INFP("INFP"),
	ENFJ("ENFJ"),
	ENFP("ENFP"),
	
	//Sentinelas
	ISTJ("ISTJ"),
	ISFJ("ISFJ"),
	ESTJ("ESTJ"),
	ESFJ("ESFJ"),
	
	//Exploradores
	ISTP("ISTP"),
	ISFP("ISFP"),
	ESTP("ESTP"),
	ESFP("ESFP");
	
	public String perfilValue;
	
	private PerfilEnum(String perfilValue)
	{
		this.perfilValue = perfilValue;		
	}
	
	public String getPerfilValue()
	{
		return this.perfilValue;
	}
}
