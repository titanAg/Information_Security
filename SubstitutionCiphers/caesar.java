public class caesar {
	
	// Rotate - function for shifting a character n letters
	// This function takes a character c and shifts it n letters
	// For example, if c = A and n = 1, it would return 'B'
	// If c = A and n = 2, it would return 'C', and so forth
	public static char rotate(char c, int n) {
		//TODO - Complete this function.
	}
	
	// Cipher - function for adjustable Caesar Cipher
	// This function takes a string input and an offset integer n
	// It then uses the rotate function above to shift each character
	// in the string n characters, and returns the fully-shifted string
	public static String cipher(String input, int n) {
		//TODO - Complete this function.
	}
	
	// Polyalpha - function for simple polyalphabetic cipher
	// This function works just like the cipher function, but takes
	// two input integer offsets, n and z. It uses the n offset for every
	// even letter, and the z offset for every odd letter in the input
	// string.
	public static String polyalpha(String input, int n, int z) {
		//TODO - Complete this function.
	}

	// Testing section
	public static void main(String[] args) {
		// This should return 'F' if your rotate function is working properly
		System.out.println(rotate('B', 30));
		// This should return 'URYYBJBEYQ' if your rotate and cipher functions are working properly
		System.out.println(cipher("HELLOWORLD", 13));
		// This should return 'HELLOWORLD' if your rotate and cipher functions are working properly
		System.out.println(cipher("URYYBJBEYQ", 13));
		// This should return 'UVYCBNBIYU' if your polyalpha function is working properly
		System.out.println(polyalpha("HELLOWORLD", 13, 17));
	}
	
	// Decode this secret message: MAXLXVKXMBLMATMMABLBLGMLXVNKX

}
