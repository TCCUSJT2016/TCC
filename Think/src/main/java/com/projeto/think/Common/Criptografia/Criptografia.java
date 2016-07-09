package com.projeto.think.Common.Criptografia;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;

public class Criptografia
{
	@Value("#{contextProperties['cripto.chave']}")
	private String chave;
	
	public String criptografar(String item) throws  NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
													InvalidAlgorithmParameterException, IllegalBlockSizeException, 
													BadPaddingException
	{
		byte[] textoCifrado;
		
		SecretKey secretKey = (SecretKey) ((Object) chave);
		byte[] chave = secretKey.getEncoded();
		
		Cipher cipherAES = Cipher.getInstance ("AES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec (new byte[16]);
		
		cipherAES.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivParameterSpec);
		textoCifrado = cipherAES.doFinal (this.toByteArray(item));
		
		return this.toString(textoCifrado);
	}

	public String descriptografar(String item) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
													  InvalidAlgorithmParameterException, IllegalBlockSizeException,
													  BadPaddingException 
	{
		byte[] textoDecifrado;
		
		SecretKeySpec iSim = (SecretKeySpec) ((Object) chave);
		
		Cipher cipherAES = Cipher.getInstance ("AES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec (new byte[16]);
		cipherAES.init (Cipher.DECRYPT_MODE, iSim, ivParameterSpec);
		textoDecifrado = cipherAES.doFinal (this.toByteArray(item));

		
		return this.toString(textoDecifrado);
	}

	
	public byte[] toByteArray(String item)
	{
		return item.getBytes();
	}
	
	public String toString(byte[] bytes)
	{
		return new String(bytes);
	}
}