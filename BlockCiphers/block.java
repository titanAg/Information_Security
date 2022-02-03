// Kyle Orcutt
// COSC 232 Lab 3

// This class will implement a simple block cipher using a custom
// mixing round function and a simple Electronic Code Book (ECB)
// mode of operation implementation.
public class block {
	
	// rotRight - This function rotates an input byte right
	// This shifts all bits to the right, and shuffles the last
	// bit in the byte to the front, i.e. 10000111 becomes 11000011
	// The number of bits to shift is set by the integer shift
	public static byte rotRight(byte input, int shift) {
		return (byte) ((input & 0xFF) >>> shift | (input & 0xFF) << (8 - shift));
	}
	
	// rotLeft - This function rotates an input byte left
	// This shifts all bits to the left, and shuffles the first
	// bit in the byte to the back, i.e. 10000111 becomes 00001111
	// The number of bits to shift is set by the integer shift
	public static byte rotLeft(byte input, int shift) {
		return (byte) ((input & 0xFF) << shift | (input & 0xFF) >>> (8 - shift));
	}
	
	// round - This function takes two bytes, and should perform
	// an ARX-style mutation on the two bytes using consecutive
	// addition, XOR, and rotation functions. It returns an array
	// of the two bytes after mixing.
	public static byte[] round(byte a, byte b) {
		a += b;
		b = rotLeft(b, 2);
		a ^= b;
		byte[] out = {a,b};
		return out;
	}
	
	// roundInverse - This function takes two bytes and performs
	// the inverse of the round() function on them. This means it
	// reverses the mixing performed in the round() function, and
	// returns the original values of a and b before mixing as an
	// array of two bytes.
	public static byte[] roundInverse(byte a, byte b) {
		a ^= b;
		b = rotRight(b, 2);
		a -= b;
		byte[] out = {a,b};
		return out;
	}
	
	// encryptBlock - This function takes an input array of bytes data,
	// an array of bytes key, and an integer number of rounds. It should
	// loop rounds number of times, and in each iteration, should XOR the key
	// bytes and the data bytes together, then perform the round() function
	// on the result. Each iteration should use the output of the previous
	// iteration as the data bytes, so this is in effect performing XOR
	// and round multiple times consecutively on our inputs.
	public static byte[] encryptBlock(byte[] data, byte[] key, int rounds) {
		for (int i = 0; i < rounds; i++) {
			data[0] ^= key[0];
			data[1] ^= key[1];
			data = round(data[0], data[1]);
		}
		return data;
	}
	
	// decryptBlock - This function should perform the inverse of the
	// encryptBlock function - it should perform roundInverse() on the
	// input, then XOR with the key bytes. It should do this rounds number
	// of times. Output from this function should decrypt the output of
	// the encryptBlock function.
	public static byte[] decryptBlock(byte[] data, byte[] key, int rounds) {
		for (int i = 0; i < rounds; i++) {
			data = roundInverse(data[0], data[1]);
			data[0] ^= key[0];
			data[1] ^= key[1];
		}
		return data;
	}
	
	// ecbEncrypt - You should implement a basic ECB mode of operation here.
	// It takes some data in of a length (divisible by two), and then performs
	// the encryptBlock() function on each 2-byte block. It should then return
	// a byte array of the complete encrypted message in bytes.
	public static byte[] ecbEncrypt(byte[] data, byte[] key) {
		for (int i = 0; i < data.length; i+=2) {
			byte[] temp = {data[i],data[i+1]};
			temp = encryptBlock(temp, key, 5);
			data[i] = temp[0];
			data[i+1] = temp[1];
		}
		return data;
	}
	
	// ecbDecrypt - This should use the decryptBlock() function to decrypt our
	// ciphertext and reproduce the plaintext.
	public static byte[] ecbDecrypt(byte[] data, byte[] key) {
		for (int i = 0; i < data.length; i+=2) {
			byte[] temp = {data[i],data[i+1]};
			temp = decryptBlock(temp, key, 5);
			data[i] = temp[0];
			data[i+1] = temp[1];
		}
		return data;
	}

	public static void main(String[] args) {
		// This will help test your internal functions
		byte[] testInput = {22, (byte) 144}; // Test data input
		byte[] testKey = {(byte) 192, 44}; // Test key
		byte[] roundTest = round(testInput[0], testInput[1]);
		byte[] inverseRoundTest = roundInverse(roundTest[0], roundTest[1]);
		System.out.println(inverseRoundTest[0]); // This should print 22
		System.out.println(inverseRoundTest[1]); // This should print -112
		byte[] ciphertext = encryptBlock(testInput, testKey, 10);
		byte[] plaintext = decryptBlock(ciphertext, testKey, 10);
		System.out.println(plaintext[0]); // This should print 22
		System.out.println(plaintext[1] & 0xFF); // This should print 144
		// This will help you test the block-cipher ECB mode encryption
		byte[] testLong = "Hello World, this is my block cipher".getBytes();
		byte[] ecbEncrypt = ecbEncrypt(testLong, testKey); // Encrypt the message
		System.out.println(new String(ecbEncrypt));

		byte[] ecbDecrypt = ecbDecrypt(ecbEncrypt, testKey); // Decrypt the message
		System.out.println(new String(ecbDecrypt));
		// Above line should print out "Hello World, this is my block cipher"
	}

}