// Kyle Orcutt
// 232 - lab 2 

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class myRandom {
	
	long state; // internal state
	
	public myRandom(long seed) {
		this.state = seed;
	}
	
	public long getRand() {
		this.state ^= this.state >> 12;
		this.state ^= this.state << 25;
		this.state ^= this.state >> 27;
		return this.state * 2685821657736338717L;
	}

	// Testing section
	public static void main(String[] args) {
		// First, we create the random object with seed = "1234"
		myRandom newRand = new myRandom(1234);
		// Then we generate an integer - this should return -4875686705675355890
		System.out.println(newRand.getRand());
		// This should return 5609927630774915935
		System.out.println(newRand.getRand());
		// And this should return 7579251470305882622
		System.out.println(newRand.getRand());
		// Create output files for our generator and the default Java Generator if you want to compare them
		try {
			// Write a file with 1000000 longs from our Xorshift* generator
			Writer fileWriter = new FileWriter("myRandOutput.txt", false);
			for(int x = 0; x < 1000000; x++) {
				fileWriter.write(String.valueOf(newRand.getRand()));
			}
			fileWriter.close();
			// Do the same but use the Java Random library
			Random rand = new Random();
			fileWriter = new FileWriter("javaRandOutput.txt", false);
			for(int x = 0; x < 1000000; x++) {
				fileWriter.write(String.valueOf(rand.nextLong()));
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
