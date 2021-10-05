package com.sesegi.streams;

import java.util.function.IntConsumer;

public class Averager implements IntConsumer{
	
	private int count = 0;
	private int total = 0;
	
	public double average() {
		return count > 0 ? total/count : 0;
	}

	@Override
	public void accept(int value) {
		count++;
		total+=value;
	}
	
	public void combine(Averager averager) {
		this.count += averager.count;
		this.total += averager.total;
	}

}
