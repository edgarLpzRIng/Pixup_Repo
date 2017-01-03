package mx.unam.dgscati.pixup.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import mx.unam.dgscati.pixup.exception.PixUpSeguridadException;

public class Security {
	
	private final static String ALGORITMO_CIFRADO = "MD5";
	
	public static String cifrarPassword(String textoClaro){
		
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITMO_CIFRADO);
			byte[] hashCadena = md.digest(textoClaro.getBytes());
			BigInteger bigInteger = new BigInteger(1,hashCadena);
			String hash = bigInteger.toString(16);
//			System.out.println("hash: "+hash);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new PixUpSeguridadException();
		}
	}

}
