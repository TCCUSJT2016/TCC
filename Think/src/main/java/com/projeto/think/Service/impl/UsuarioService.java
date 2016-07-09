package com.projeto.think.Service.impl;


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.think.Common.Criptografia.Criptografia;
import com.projeto.think.Model.Candidato;
import com.projeto.think.Repository.impl.UsuarioDAO;
import com.projeto.think.Service.IService;

@Service
public class UsuarioService implements IService
{
	@Autowired
	private UsuarioDAO usuarioDAO;
	

	public Map<String, Object> cadastrar(Object usuario)
	{
		if(usuario instanceof Candidato)
		{
			try
			{
				usuarioDAO.cadastrar(usuario);
			}
			catch(Exception e)
			{
				return null;
			}
		}
		
		return null;
	}
	
	public Map<String, Object> cadastrar(List<Object> usuarios)
	{
		for(Object usuario : usuarios)
		{
			if(usuario instanceof Candidato)
			{
				try
				{
					usuarioDAO.cadastrar(usuario);
				}
				catch(Exception e)
				{
					return null;
				}
			}
		}
		return null;
	}
	
	
	//@param - String login
	public boolean getUsuario(String login)
	{
		return false;
	}
	
	public Map<String, Object> consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String criptografar(String item) throws  InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
													InvalidAlgorithmParameterException, IllegalBlockSizeException,
													BadPaddingException
	{
		Criptografia criptografia = new Criptografia();
		return criptografia.criptografar(item);
	}

}
