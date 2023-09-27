package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		int sum;

		if (a > 0 && b > 0) {
			sum = a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}

		return sum;
	}
	
	//method to determine if there is a remainder
	public int determineRemainder(int a, int b) {
		int remNum = a % b;//line that performs the modulo expression
		
		if(remNum == 0) {//if there is no remainder print this message
			System.out.println("There is no remainder");
		}else {//if there is a remainder, throw this exception
			throw new IllegalArgumentException("The remainder must be 0!");
		}
			
		return remNum;//returns the remainder
	}

	public int randomNumberSquared() {
		int numSquared = getRandomInt();
	return numSquared * numSquared;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}

}