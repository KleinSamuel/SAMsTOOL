package io;

import java.io.File;
import java.io.IOException;

/**
 * Temporary file handling
 * 
 * @author Samuel Klein
 */
public class TemporaryFile {

	/**
	 * Create a temporary file which will be deleted after JVM exits.
	 * 
	 * @param prefix filename
	 * @param suffix file ending, if empty ".tmp" will be used
	 * @param filepath where file is stored
	 * @return File
	 */
	public static File createTempFile(String prefix, String suffix, String filepath){
		File out = null;
		try {
			out = File.createTempFile(prefix, suffix, new File(filepath));
			out.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
	
}
