package com.sesegi.concurreny.parallelstream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class WhaleDataCalculator {
	
	private int processRecord(int i) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i+1;
	}
	
	private void processAllData(List<Integer> list) {
//		list.stream().map(i -> processRecord(i)).count();

		list.parallelStream().map(i -> processRecord(i)).count();
	}
	
	public static void main(String[] args) {
		WhaleDataCalculator app = new WhaleDataCalculator();
		
		List<Integer> data = new ArrayList<Integer>();
		for(int i = 0; i<4000; i++) {
			data.add(i);
		}
		
		Instant start = Instant.now();
		app.processAllData(data);
		Instant end = Instant.now();
		
		System.out.println("Process completed in " + Duration.between(start, end).getSeconds() + "seconds.");
	}

}
