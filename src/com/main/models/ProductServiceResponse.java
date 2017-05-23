package com.main.models;

import java.util.HashMap;

public class ProductServiceResponse  extends MainResponse{
	private int counter =0;
	

	public void setCounter(int i) {
		this.counter = i;
	}
	
	public void incrementCounter() {
		this.counter++;
	}

	public int getCounterValue() {
		// TODO Auto-generated method stub
		return this.counter;
	}

	

}
