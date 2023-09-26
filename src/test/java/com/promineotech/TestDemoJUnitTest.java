package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class TestDemoJUnitTest {
	// private instance variable
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		// creates new TestDemo obj. ensures new TestDemo is created before each test
		testDemo = new TestDemo();
	}

	// changed "test to parameterizedtest"
	// added methodsource below w/ 'class name#'method that provides parameters
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNubmerAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {// asserts that td.aP is called w/ a & b result is the same as 'expected'
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	// parameter source method
	static Stream<Arguments> argumentsForAddPositive() {// static method that returns stream of arguments
		//@formatter:off
		return Stream.of(//had to import org.junit...Arguments and static org...arguments
				arguments(1, 3, 4, false),//these arguments are to test that you get the result
				arguments(-1, 2, 1, true),//ie 1+3=4 no exception expected so false
				arguments(0, 2, 2, true),//any negative #'s and 0s will throw exceptions
				arguments(0, -1, -1, false)
				);
		//@formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
	assertThat(testDemo.addPositive(1, 5)).isEqualTo(6);
	assertThat(testDemo.addPositive(52, 48)).isEqualTo(100);
	
	
	}

}
