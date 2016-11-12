package crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {

	/**
	 * KeyPair contains private and public key
	 */
	private KeyPair key = null;
	
	/**
	 * Generate a KeyPair
	 */
	public void gen(){
		
		KeyPairGenerator keyGen = null;
		
		try {
			
			keyGen = KeyPairGenerator.getInstance("RSA");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		keyGen.initialize(1024);
		this.key = keyGen.generateKeyPair();
		
	}
	
	/**
	 * Encrypt a message with a public key
	 * 
	 * @param message String
	 * @param publicKey PublicKey
	 * @return byte[] encrypted message
	 */
	public byte[] encrypt(String message, PublicKey publicKey){
		
		Cipher cipher = null;
		
		try {
			
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		byte[] chiffrat = null;
		
		try {
			
			chiffrat = cipher.doFinal(message.getBytes());
			
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return chiffrat;
	}
	
	/**
	 * Decrypt a encrypted message with the private key
	 * 
	 * @param encryptedMessage
	 * @param privateKey
	 * @return
	 */
	public String decrypt(byte[] encryptedMessage, PrivateKey privateKey){
		
		byte[] decrypted = null;
		
		Cipher cipher = null;
		
		try {
			
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		try {
			
			decrypted = cipher.doFinal(encryptedMessage);
			
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return new String(decrypted);
	}

	/**
	 * Get the current KeyPair
	 * 
	 * @return KeyPair
	 */
	public KeyPair getKey() {
		return key;
	}
}
