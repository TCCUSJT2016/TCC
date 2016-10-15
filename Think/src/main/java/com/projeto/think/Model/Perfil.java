package com.projeto.think.Model;

import java.io.Serializable;

import com.projeto.think.Common.Enum.PerfilEnum;

public class Perfil implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private PerfilEnum codigo;
	private String tipoPerfil;
	
	public Perfil()
	{
		this.setId(0);
		this.setCodigo(null);
		this.setTipoPerfil(null);
	}
	
	public Perfil(int id, PerfilEnum codigo, String tipoPerfil)
	{
		this.setId(id);
		this.setCodigo(codigo);
		this.setTipoPerfil(tipoPerfil);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public PerfilEnum getCodigo() {
		return codigo;
	}
	
	public void setCodigo(PerfilEnum codigo) {
		this.codigo = codigo;
	}
	
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
}
