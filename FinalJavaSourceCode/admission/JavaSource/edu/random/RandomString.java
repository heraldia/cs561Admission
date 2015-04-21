package edu.random;

import java.util.Random;

public class RandomString {

	/**
	   * random String
	   * */
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	
	/**
	 * return a random string of length k
	 * @return a string
	 */
	public static final String randomString1(int length) {
	         if (length < 1) {
	             return null;
	         }
	         if (randGen == null) {
	                randGen = new Random();
	                numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" 
//	                +                  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                		).toCharArray();
	                  //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	                 }
	         char [] randBuffer = new char[length];
	         for (int i=0; i<randBuffer.length; i++) {
//	             randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
	          randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
	         }
	         return new String(randBuffer);
	}
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
//			System.out.println(randomString1(6)+"@"+randomString1(4)+"."+randomString1(3));
			System.out.println(randomString1(3)+"\""+randomString1(5)+","+randomString1(4)+"."+randomString1(3)+"\""+randomString1(6)+","+randomString1(4)+"."+randomString1(3));
//			String str =  randomString1(5); 
//			System.out.println(str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase()));
		}
	}

}
