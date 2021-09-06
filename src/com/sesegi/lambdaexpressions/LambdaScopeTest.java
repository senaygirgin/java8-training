package com.sesegi.lambdaexpressions;

import java.util.function.Consumer;

public class LambdaScopeTest {
	int x = 10;
	
	class FirstLevel{
		int x = 20;
		
		void firstLevelMethod(int x) {
			int y = 30;
			
			Consumer<Integer> cons = (z) ->{
//				x = 100;
//				y = 300;
				this.x = 200;
				LambdaScopeTest.this.x = 100;
				
				System.out.println(z);
				System.out.println(y);
				System.out.println(x);
				System.out.println(x == z);
				System.out.println(this.x);
				System.out.println(LambdaScopeTest.this.x);
			};
			
			cons.accept(x);
		}
	}
	
	public static void main(String[] args) {
		LambdaScopeTest test = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel level = test.new FirstLevel();
		level.firstLevelMethod(50);
	}

}
