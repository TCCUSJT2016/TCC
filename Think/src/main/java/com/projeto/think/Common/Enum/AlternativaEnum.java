package com.projeto.think.Common.Enum;

public enum AlternativaEnum
{	
	ALTERNATIVAA("A"),
	ALTERNATIVAB("B"),
	ALTERNATIVAC("C"),
	ALTERNATIVAD("D"),
	ALTERNATIVAE("E");
	
	public String alternativaValue;
	
	private AlternativaEnum(String alternativaValue)
	{
		this.alternativaValue = alternativaValue;		
	}
	
	public String getAlternativaValue()
	{
		return this.alternativaValue;
	}
}
