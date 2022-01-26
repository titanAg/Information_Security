// Kyle Orcutt
// 232 - lab 2 Xorshift* PRNG function

public class stream {
	
	myRandom rand; // internal PRNG generator
	
	public stream(long seed) {
		rand = new myRandom(seed);
	}
	
	// encrypt & decrypt 
	public String encrypt(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			int n = input.charAt(i);
			n ^= Math.abs(((int)rand.getRand() % 10)); // XOR'd with rand class
			output += (char)n;
		}
		return output;
	}

	// Testing section
	public static void main(String[] args) {
		// First, we create the stream object with seed = "1234"
		stream cipher = new stream(1234);
		// Pass in a phrase to the encrypt function to encrypt it
		// This should print "llhon!vorng+&mru$aipf"
		System.out.println(cipher.encrypt("hello world, its cosc"));
		// Create a new stream object with the same seed
		stream cipher_2 = new stream(1234);
		// Use it to decrypt the previous message by running it back through
		// This should print "hello world, its cosc"
		System.out.println(cipher_2.encrypt("llhon!vorng+&mru$aipf"));
		
	}

}