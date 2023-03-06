package com.emp.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncrptDecrptUtility {

	 private static SecretKeySpec secretKey;
	 private static byte[] key;
	  private static final String ALGORITHM = "AES";

	public static void main(String[] args) {
		
		String s1 = new String("HELLO");
		String s2 = "HELLO";
		System.out.println(s1==s2);
		// TODO Auto-generated method stub
		String secret = "empManagement";
		PasswordEncrptDecrptUtility test = new PasswordEncrptDecrptUtility();
		
		String encrypt = test.encrypt("admin@123", secret);
		System.out.println(encrypt);
		
		String decrypt = test.decrypt("JhD4TkSGX2RolDo7081L6w==", secret);
		System.out.println(decrypt);
		
	}
	
	
	public String encrypt(String strToEncrypt, String secret) {
	    try {
	        prepareSecreteKey(secret);
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } catch (Exception e) {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	public String decrypt(String strToDecrypt, String secret) {
	    try {
	        prepareSecreteKey(secret);
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	
	  public void prepareSecreteKey(String myKey) {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes(StandardCharsets.UTF_8);
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16);
	            secretKey = new SecretKeySpec(key, ALGORITHM);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	    }
}
