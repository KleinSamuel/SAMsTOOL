package crypto;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;

public class DataLocker{

	private final String ALGORITHM = "AES";
    private final String TRANSFORMATION = "AES";
	
	public SecretKeySpec getPassword(){
		Console console = System.console();
	    if (console == null) {
	        System.out.println("Couldn't get Console instance");
	        System.exit(0);
	    }
	    char[] passwordArray = console.readPassword("Password: ");
	    byte[] key;
	    SecretKeySpec secretKeySpec = null;
		try {
			
			key = String.valueOf(passwordArray).getBytes("UTF-8");
			MessageDigest sha;
			sha = MessageDigest.getInstance("SHA-256");
			key = sha.digest(key);
		    key = Arrays.copyOf(key, 16);
		    secretKeySpec = new SecretKeySpec(key, ALGORITHM);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return secretKeySpec;
	}
	
	public byte[] getFileAsByteArray(String filepath){
		byte[] array = null;
		try {
			array = FileUtils.readFileToByteArray(new File(filepath));
		} catch (IOException e) {
			
			System.out.println("File not found.");
			System.exit(0);
//			e.printStackTrace();
		}
		return array;
	}
	
	public void writeFileFromByteArray(String filepath, byte[] data){
		try {
			FileUtils.writeByteArrayToFile(new File(filepath), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
    public byte[] encrypt(SecretKeySpec key, byte[] data){
       return doCrypto(Cipher.ENCRYPT_MODE, key, data);
    }
 
    public byte[] decrypt(SecretKeySpec key, byte[] data) {
        return doCrypto(Cipher.DECRYPT_MODE, key, data);
    }
 
    private byte[] doCrypto(int cipherMode, SecretKeySpec key, byte[] data){
    	byte[] outputBytes = null;
    	try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, key);
            outputBytes = cipher.doFinal(data);
            
    	} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			
			System.out.println("Decryption failed.");
			System.exit(0);
		}
    	return outputBytes;
    }
	
	public static void main(String[] args) {
		
		DataLocker r = new DataLocker();
		String path = args[1];
		
		if(args[0].equals("-encrypt")){
			r.writeFileFromByteArray(path+".crypto", r.encrypt(r.getPassword(), r.getFileAsByteArray(path)));
			System.out.println("Encryption finished.");
		}else if(args[0].equals("-decrypt")){
			r.writeFileFromByteArray(path.substring(0, path.lastIndexOf(".")), r.decrypt(r.getPassword(), r.getFileAsByteArray(path)));
			System.out.println("Decryption finished.");
		}
		
	}
}
