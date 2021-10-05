package com.sesegi.methodreferences;

import com.sesegi.lambdaexpressions.Person;

public class ComparisonProvider {


	public static int compareByAge(Person a, Person b) {
		return a.getBirthday().compareTo(b.getBirthday());
	}
	
	public static int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
}
