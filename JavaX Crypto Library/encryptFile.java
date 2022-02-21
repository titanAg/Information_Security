import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encryptFile {
	
	
	// The crypt() function encrypts or decrypts a byte array input, using
	// an 16-byte initialization vector (init), 16-byte password (pass),
	// and an integer mode (either Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE)
	public static byte[] crypt(byte[] input, byte[] init, byte[] pass, int mode) {
		// TODO - Fill this out.
	}
	
	// The cryptFile() function opens a file at a specified string path,
	// then passes in the init, pass, and mode values to the crypt() function
	// to either encrypt or decrypt the contents of the file. It then writes
	// the encrypted or decrypted data back to the file. Note that it should
	// overwrite the existing file - so don't try it on a file that's actually
	// worth anything!
	public static void cryptFile(String path, byte[] init, byte[] pass, int mode) {
		// TODO - Fill this out.
	}
	
	// The menu() function provides a user interface for the script. It should
	// prompt the user to enter a file path, 16-byte initialization vector,
	// 16-byte password, and a mode (encrypt or decrypt). If the password or
	// initialization vector are too short or too long, the function should
	// re-prompt the user to re-enter the value.
	public static void menu() {
		// TODO - Fill this out.
	}

	// Just need to call the menu() function here
	public static void main(String[] args) {
		// Tests for crypt();
		byte[] plain = "Hello World".getBytes();
		byte[] pass = "aaaabbbbccccdddd".getBytes();
		byte[] init = "gggggggggggggggg".getBytes();
		byte[] cipher = crypt(plain, init, pass, Cipher.ENCRYPT_MODE);
		byte[] decrypted = crypt(cipher, init, pass, Cipher.DECRYPT_MODE);
		// This should print "Hello World"
		System.out.println(new String(decrypted));
		
		// Uncomment below to test menu section once complete
		//menu();
	}

}
