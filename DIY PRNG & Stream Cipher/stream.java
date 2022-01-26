// You should import your myRandom class here

//In this class you should implement the Xorshift* PRNG function
//(See lecture notes if you're unsure how that works)
public class stream {
	
	// This is the internal PRNG generator
	myRandom rand;
	
	// Constructor - In this function, you should create a new
	// myRandom object using the input long seed, and then store it
	// in the rand class variable.
	public stream(long seed) {
		// TODO: Complete this.
	}
	
	// In this function you should use a loop to select each character in
	// the input string. You should use the charAt() function to convert
	// the character to an integer. You should then XOR that integer with:
	// Math.abs(((int)rand.getRand() % 10)), which will return pseudorandom
	// number between 0 and 10.
	// Then, append the character to the output. Once all characters have been
	// XOR'd, you should return the output.
	// Note: This function also serves to decrypt an encrypted message.
	public String encrypt(String input) {
		// TODO: Complete this.
		// Math.abs(((int)this.rand.getRand() % 10));
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