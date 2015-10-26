package com.sun.steve.future;

import java.util.concurrent.Callable;

/**
 * This class is used to help me understand Future class, Future class must be assinged from the Executors. class's submit() method to process
 * an argument which implements Callable interface, that's why I have this class called MyCallable here!*/
public class MyCallable implements Callable {

	@Override
	public String call() throws Exception {
		Thread.sleep(1500);
		return Thread.currentThread().getName();
	}
	
}
