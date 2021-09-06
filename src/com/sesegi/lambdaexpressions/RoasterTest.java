package com.sesegi.lambdaexpressions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.sesegi.lambdaexpressions.Person.Sex;

public class RoasterTest {
	
	public static void printPersonsOlderThan(List<Person> personList, int age) {
		for(Person p: personList) {
			if(p.getAge() > age) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersonsWithPredicate(List<Person> personList, Predicate<Person> tester) {
		for(Person p: personList) {
			if(tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public static void processPersons(List<Person> personList, Predicate<Person> tester, Consumer<Person> block) {
		for(Person p: personList) {
			if(tester.test(p)) {
				block.accept(p);
			}
		}
	}
	
	public static <X, Y> void processElements(Iterable<X> elementList, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for(X p : elementList) {
			if(tester.test(p)) {
				Y y = mapper.apply(p);
				block.accept(y);
			}
		}
		
	}
	
	public static void main(String[] args) {
		List<Person> personList = Person.createList();
		
		printPersonsOlderThan(personList, 35);
		printPersonsWithPredicate(personList, p -> p.getAge() > 25 && p.getGender() == Sex.FEMALE);
		processPersons(personList, p -> p.getAge() > 18 && p.getGender() == Sex.MALE, p -> System.out.println(p.getEmailAddress()));
		processPersons(personList, p -> p.getAge() > 18 && p.getGender() == Sex.MALE, p -> p.printPerson());
		processElements(personList, p -> p.getAge() > 18 && p.getGender() == Sex.MALE, p -> p.getEmailAddress(), p -> System.out.println(p));
		System.out.println("==== STREAM ====");
		personList.stream().filter( p -> p.getAge() > 18 && p.getGender() == Sex.MALE).map(p -> p.getEmailAddress()).forEach(System.out::println);
	}

}
