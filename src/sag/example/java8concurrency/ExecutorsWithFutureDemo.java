/**
 * 
 */
package sag.example.java8concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author alokkumar
 *
 */
public class ExecutorsWithFutureDemo {

	public static void main(String[] args) {
		System.out.println("Hello Meetup");

		// Adders and Accumulatores
		// Common Pool

		ExecutorService executors = Executors.newFixedThreadPool(5);
		Future<Double> future = executors.submit(() -> {
			System.out.println("Result is ready");
			return 50000D;
		});

		while (true) {
			if (future.isDone())
				try {
					System.out.println("Balance : " + future.get());
					break;
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
		}

		executors.shutdown();
	}

}
