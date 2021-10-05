package com.sesegi.methodreferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.sesegi.lambdaexpressions.Person;

public class MethodReferencesTest {
	
	public static void main(String[] args) {
		List<Person> personList = Person.createList();
		Person[] personListArray = personList.toArray(new Person[personList.size()]);
		
		System.out.println(Arrays.asList(personListArray));
		
//		Arrays.sort(personListArray, new AgeComparator());
//		Arrays.sort(personListArray, (Person a, Person b) -> a.getBirthday().compareTo(b.getBirthday()));
//		Arrays.sort(personListArray, (Person a, Person b) -> Person.compareByAge(a, b));
		Arrays.sort(personListArray, ComparisonProvider::compareByAge);
		System.out.println(Arrays.asList(personListArray));
		
		Arrays.sort(personListArray, ComparisonProvider::compareByName);
		Arrays.asList(personListArray).stream().forEach(Person::printPerson);
	}

	static class AgeComparator implements Comparator<Person>{

		@Override
		public int compare(Person a, Person b) {
			return a.getBirthday().compareTo(b.getBirthday());
		}
		
	}
}
