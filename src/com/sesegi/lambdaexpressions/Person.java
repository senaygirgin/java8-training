package com.sesegi.lambdaexpressions;

import java.time.LocalDate;
import java.time.Period;

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
}