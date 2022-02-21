import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// 232 L4 - Javax Crypto
// Kyle Orcutt


public class encryptFile {
	
	
	// The crypt() function encrypts or decrypts a byte array input, using
	// an 16-byte initialization vector (init), 16-byte password (pass),
	// and an integer mode (either Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE)
	public static byte[] crypt(byte[] input, byte[] init, byte[] pass, int mode) {
		IvParameterSpec ivpSpec = new IvParameterSpec(init);
		SecretKeySpec skSpec = new SecretKeySpec(pass, "AES");
		Cipher cipher;
		byte[] out = {};
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(mode, skSpec, ivpSpec);
			out = cipher.doFinal(input);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return out;
	}

	public static byte[] crypt2(byte[] input, byte[] init, byte[] pass, int mode) {
		IvParameterSpec ivpSpec = new IvParameterSpec(init);
		SecretKeySpec skSpec = new SecretKeySpec(pass, "DES");
		Cipher cipher;
		byte[] out = {};
		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(mode, skSpec, ivpSpec);
			out = cipher.doFinal(input);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return out;
	}
	
	// The cryptFile() function opens a file at a specified string path,
	// then passes in the init, pass, and mode values to the crypt() function
	// to either encrypt or decrypt the contents of the file. It then writes
	// the encrypted or decrypted data back to the file. Note that it should
	// overwrite the existing file - so don't try it on a file that's actually
	// worth anything!
	public static void cryptFile(String path, byte[] init, byte[] pass, int mode, int type) {
		Path file = Paths.get(path);
		try {
			byte[] output = {};
			if (type == 1)
				output = crypt(Files.readAllBytes(file), init, pass, mode);
			else if (type == 2)
				output = crypt2(Files.readAllBytes(file), init, pass, mode);
			file = Files.write(file, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// The menu() function provides a user interface for the script. It should
	// prompt the user to enter a file path, 16-byte initialization vector,
	// 16-byte password, and a mode (encrypt or decrypt). If the password or
	// initialization vector are too short or too long, the function should
	// re-prompt the user to re-enter the value.
	public static void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter File Path:");
		String filePath = input.nextLine();

		String t = "";
		do {
			System.out.println("Enter 1 for AES enter 2 for DES: ");
			t = input.nextLine();
		} while (!t.toLowerCase().equals("1") && !t.toLowerCase().equals("2"));
		int type = Integer.parseInt(t);
		int byteLimit = type == 1 ? 16 : 8;

		String initVector = "";
		do {
			System.out.println("Enter Initialization Vector (" + byteLimit + " chars):");
			initVector = input.nextLine();
		} while (initVector.length() != byteLimit);

		String pass = "";
		do {
			System.out.println("Enter Password (" + byteLimit + " chars):");
			pass = input.nextLine();
		} while (pass.length() != byteLimit);

		String mode = "";
		do {
			System.out.println("Enter mode: encrypt or decrypt:");
			mode = input.nextLine();
		} while (!mode.toLowerCase().equals("encrypt") && !mode.toLowerCase().equals("decrypt"));

		cryptFile(filePath, initVector.getBytes(), pass.getBytes(), (mode.toLowerCase().equals("encrypt") ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE), type);
		System.out.println("Done");
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
		
		// AES
		// aaaabbbbccccdddd
		// thisis16bytesyes
		
		// DES
		// aaaabbbb
		// 8bytes12

		menu();
	}

}
