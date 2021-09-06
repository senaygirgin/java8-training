package com.sesegi.lambdaexpressions;

public class Calculator {
	
	interface IntegerMath{
		int operation(int a, int b);
	}
	
	int doOperation(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}
	
	public static void main(String[] args) {
		IntegerMath addOperation = (a, b) -> a + b;
		IntegerMath substract = (a, b) -> a - b;
		
		Calculator calc = new Calculator();
		System.out.println(calc.doOperation(10, 15, addOperation));
		System.out.println(calc.doOperation(20, 3, substract));
	}

}
