import java.util.Arrays;
import java.util.Scanner;

/*
 * Melecia Young
 * CS 3345.005
 * Assignment 1: Sieve of Eratosthenes
 * 
 * Goal:
 * 	get user input (n), make an array booleans from 2 to n, check to see if any of the numbers
 *	are prime for multiples of 2, 3, 4, etc., and finally print each prime number from 2 to n
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeNumbers(getNumber());
	
	}

	
	/*
	 * the parameter of the method is the number obtained from the user 
	 */
	public static void primeNumbers(int n) {
		boolean array[] = new boolean[n+1]; //creating an array of booleans
		Arrays.fill(array, true); //setting every element in the array to true since we don't know which are not prime yet 
		int multiplier = 0; //initialize the multiplier to be used in the inner for loop 

		for(int i = 2; i <= Math.sqrt(n); i++) { // starts at 2 and goes to the square root of n, increments by 1 each time
			//System.out.println("I "+ i); // printed this to make sure it was incremented properly 
			
			if(array[i] == true) { //if its not already proven to be prime then enter the for loop 
					for(int j = (int) Math.pow(i, 2); j <= n; j=(int)Math.pow(i, 2) + (multiplier*i)) { //increments by i^2 + multiplier*i
						//System.out.println("J " +j); // printed this to make sure it was incremented properly 
						array[j] = false; //set the element to false
						multiplier++; //increment the multiplier by one to test the next group of numbers
					}
			}
			multiplier = 0; // reset the multiplier so its prepared for the next increment of the i index 
			
		}
		
		
		for(int i = 2; i < array.length; i++) { // print out the prime numbers!
			if(array[i] == true) { 
				System.out.println(i);
			}
		}
		
	}
	
	
	
	/*
	 * this method is being used only to obtain user input
	 */
	public static int getNumber() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number."); //prompt for user
		
		String numStr = in.nextLine();
		int n = Integer.parseInt(numStr); // user input converted to an int
		 
		return n; //return user input 
	
	}


}
