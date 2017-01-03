package mx.unam.dgscati.pixup.util;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import mx.unam.dgscati.pixup.exception.PixUpSeguridadException;

public class Seguridad {

	public static String toMD5(String valor) throws PixUpSeguridadException {
        String cifrado;
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            String cadena = valor;
            digest.update(cadena.getBytes("ISO-8859-1"));
            byte[] sausage = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < sausage.length; i++) {
                hexString.append(Integer.toHexString(0xFF & sausage[i]));
            }
            cifrado = hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new PixUpSeguridadException(ex.getMessage(), ex);
        }
        return cifrado;
    }
	
}
