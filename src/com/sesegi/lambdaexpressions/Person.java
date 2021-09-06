package com.sesegi.lambdaexpressions;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.sesegi.lambdaexpressions.Person.Sex;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public int getAge() {
    	return Period.between(birthday, LocalDate.now()).getYears();
    }
    
    public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void printPerson() {
    	System.out.println(name);
    }
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress="
				+ emailAddress + "]";
	}
	
	public static List<Person> createList(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Joe", LocalDate.of(1980, 6, 25), Sex.MALE, "joe@joe.com"));
		personList.add(new Person("Georgiana", LocalDate.of(2000, 2, 12), Sex.FEMALE, "georgiana@georgiana.com"));
		personList.add(new Person("Kim", LocalDate.of(1978, 9, 3), Sex.MALE, "kim@kim.com"));
		personList.add(new Person("Chen", LocalDate.of(1990, 12, 30), Sex.FEMALE, "chen@chen.com"));
		
		return personList;
	}
}