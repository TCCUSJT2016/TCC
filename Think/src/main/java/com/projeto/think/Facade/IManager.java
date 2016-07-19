package com.projeto.think.Facade;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.projeto.think.Manager.impl")
public interface IManager 
{
	public boolean cadastrar(Map<String, Object> params);
}
