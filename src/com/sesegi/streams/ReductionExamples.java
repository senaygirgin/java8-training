package com.sesegi.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.sesegi.lambdaexpressions.Person;
import com.sesegi.lambdaexpressions.Person.Sex;

public class ReductionExamples {
	public static void main(String[] args) {
		List<Person> personList = Person.createList();
		
		personList.stream().forEach(Person::printPerson);
		
		OptionalDouble averageManAge = personList.stream().filter(p->p.getGender() == Sex.MALE).mapToInt(Person::getAge).average();
		averageManAge.ifPresent(a-> System.out.println("Average age of men : " + a));
		
		int sumAge = personList.stream()
				.mapToInt(p->p.getAge())
				.sum();
		System.out.println("Sum of ages : " + sumAge);
		
		int sumAgeReduces = personList.stream()
				.mapToInt(Person::getAge)
				.reduce(0, (a,b) -> a+b);
		System.out.println("Sum of ages with reduce : " + sumAgeReduces);
		
		Averager aveargeAgeCollect = personList.stream()
				.mapToInt(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);
		System.out.println(aveargeAgeCollect.average());
		
		List<String> namesOfMaleMembersCollect = personList.stream()
				.filter(p->p.getGender() == Sex.MALE)
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.println("Names of male members : " + namesOfMaleMembersCollect);
		namesOfMaleMembersCollect.stream().forEach(System.out::println);
		
		
		Map<Sex, List<Person>> groupByGender = personList.stream()
		.collect(Collectors.groupingBy(Person::getGender));
		System.out.println(groupByGender);
		
		System.out.println("Person List by Gender:");
		List<Map.Entry<Sex, List<Person>>> groupByGenderList = new ArrayList<Map.Entry<Sex,List<Person>>>(groupByGender.entrySet());
		groupByGenderList.stream().forEach(m ->{
			System.out.println(m.getKey() + ": ");
			m.getValue().stream().map(Person::getName).forEach(System.out::println);
		});
		
		System.out.println("Names by Gender:");
		Map<Sex, List<String>> namesByGender = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
		List<Map.Entry<Sex, List<String>>> namesByGenderList = new ArrayList<Map.Entry<Sex,List<String>>>(namesByGender.entrySet());
		namesByGenderList.stream().forEach(l -> {System.out.println("Gender  : " + l.getKey() + ", Names " + l.getValue());});
		
		System.out.println("Total Age by Gender:");
		Map<Sex, Integer> totalAgeByGender = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
		List<Map.Entry<Sex, Integer>> totalAgeByGenderList = new ArrayList<Map.Entry<Sex,Integer>>(totalAgeByGender.entrySet());
		totalAgeByGenderList.forEach(l->System.out.println("Gender : " + l.getKey() + ", Age : " + l.getValue()));

		System.out.println("Average Age by Gender");
		Map<Sex, Double> averageAgeByGender = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.averagingInt(Person::getAge)));
		System.out.println(averageAgeByGender);
	}
}

