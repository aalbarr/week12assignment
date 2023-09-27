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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

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
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
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
				arguments(0, -1, -1, true)
				);
		//@formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
	assertThat(testDemo.addPositive(1, 5)).isEqualTo(6);
	assertThat(testDemo.addPositive(52, 48)).isEqualTo(100);
	
	
	}
	
	//my own junit test for determining a remainder
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForTheRemainder")
	void assertThatThereIsntARemainder(int a, int b, int remainder, boolean expectFalse) {//method to acertain whether 
		if(!expectFalse) {//to throw a remainder or not
			assertThat(testDemo.determineRemainder(a, b)).isEqualTo(remainder);
		}else {
			assertThatThrownBy(() -> testDemo.determineRemainder(a, b))
					.isInstanceOf(IllegalArgumentException.class);//throws an exception if there is an exception
		}
	}
	
	static Stream<Arguments> argumentsForTheRemainder() {//method that tests inputed values whether there is a remainder
		//@formatter:off                                 //or not
		return Stream.of(
				arguments(4, 2, 0, false),
				arguments(7, 2, 1, true),
				arguments(39, 5, 4, true),
				arguments(13, 3, 1, true)
				);
		//@formatter:on
	}
	
	//test for randomNumberSquared
	@Test
	void assertThatNumberSquaredIsCorrect() {//creates method, has package visibility (not public) 
		TestDemo mockDemo = spy(testDemo);//mockito.spy
						//essentially "spies" on testDemo	//mocked just means copied
		doReturn(5).when(mockDemo).getRandomInt();//programs mocked testDemo to return 5 when .getRandomInt is called
		int fiveSquared = mockDemo.randomNumberSquared();//calls method to the mocked testDemo(mockedDemo)
		assertThat(fiveSquared).isEqualTo(25);//tests that value returned from randomNumberSquared is equal to 5 squared
	}//you dont need to verify mocked method call since you know the return value is correct.
	

}




















