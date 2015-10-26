package com.sun.steve.future;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainApp {

	public static void main(String... args) {
		//Played around with different Executors, have different effects, pretty cool!
		ExecutorService executor = //Executors.newFixedThreadPool(5)
//									Executors.newSingleThreadExecutor()
//									Executors.newCachedThreadPool()
									Executors.newScheduledThreadPool(3);
		
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		Callable<String> callable = new MyCallable();
		
		for(int i = 0; i < 10; i++) {
			Future<String> future = executor.submit(callable);
			list.add(future);
		}
		
		for(Future<String> future : list){
			try {
				System.out.println(new Date() + " " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		System.out.println("That's the end of the program!");
	}

}
