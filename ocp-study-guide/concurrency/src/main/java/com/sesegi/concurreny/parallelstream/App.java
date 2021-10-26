package com.sesegi.concurreny.parallelstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5,6,7,8,9)
		.parallelStream().forEach(s-> System.out.print(s + " "));
		
		System.out.println();
		
		Arrays.asList(1,2,3,4,5,6,7,8,9)
		.parallelStream().forEachOrdered(s-> System.out.print(s + " "));
		
		System.out.println();
		
		Arrays.asList("jackal","kangaroo","lemur")
		.parallelStream().map(s-> {System.out.print(s + " "); return s.toUpperCase();}).forEach(s-> System.out.print(s + " "));
		
		System.out.println("\n----------------------------");
		
//		List<Integer> data = Collections.synchronizedList(new ArrayList<Integer>());
		List<Integer> data = new ArrayList<Integer>();
		Arrays.asList(1,2,3,4,5,6,7,8,9)
		.parallelStream().map(i -> {data.add(i); return i;}).forEach(s-> System.out.print(s + " "));
		System.out.println();
		System.out.println(data);
		
		System.out.println("----------------------------");
		
		System.out.println(Arrays.asList(1,2,3,4,5).parallelStream().findAny().get());  // any value in stream
		System.out.println(Arrays.asList(1,2,3,4,5).stream().findAny().get());  // 1
		
	}

}
