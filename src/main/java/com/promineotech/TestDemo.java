package com.promineotech;

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
}
