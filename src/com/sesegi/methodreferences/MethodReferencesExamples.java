package com.sesegi.methodreferences;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import com.sesegi.lambdaexpressions.Person;

public class MethodReferencesExamples {
	
	public static String appendStringsStatically(String first, String second) {
		return first.concat(second);
	}
	
	public String appendStrings(String first, String second) {
		return first.concat(second);
	}
	
	public static <T, U, R> R applyFuntion(T first, U second, BiFunction<T, U, R> bifunction) {
		return bifunction.apply(first, second);
	}
	
	public <T> T applyOperator(T first, T second, BinaryOperator<T> bioperator) {
		return bioperator.apply(first, second);
	}

	public static void main(String[] args) {
		MethodReferencesExamples app = new MethodReferencesExamples();
		
		System.out.println(app.appendStrings("hello", "world"));
		System.out.println(app.applyOperator("hello", "world", (a, b) -> a.concat(b)));
		System.out.println(app.applyOperator("hello", "world", MethodReferencesExamples::appendStringsStatically));
		System.out.println(app.applyOperator("hello", "world", app::appendStrings));
		System.out.println(app.applyOperator("hello", "world", String::concat));
		
		System.out.println(applyFuntion("hello", "world", (a, b) -> a.concat(b)));
		System.out.println(applyFuntion("hello", "world", MethodReferencesExamples::appendStringsStatically));
		System.out.println(applyFuntion("hello", "world", app::appendStrings));
		System.out.println(applyFuntion("hello", "world", String::concat));
		
		List<Person> personList = Person.createList();
//		Set<Person> personSet = transferElements(personList, () -> new HashSet<Person>());
		Set<Person> personSet = transferElements(personList, HashSet::new);
		
		System.out.println(personList.getClass());
		System.out.println(personSet.getClass());
		
	}
	
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE from, Supplier<DEST> toSupplier) {
		DEST destination = toSupplier.get();
		for(T t : from) {
			destination.add(t);
		}
		
		return destination;
	}
}
