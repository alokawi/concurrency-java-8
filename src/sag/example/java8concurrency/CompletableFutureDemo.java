/**
 * 
 */
package sag.example.java8concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author alokkumar
 *
 */
public class CompletableFutureDemo {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newFixedThreadPool(5);

		Supplier<Double> supplier = new Supplier<Double>() {

			@Override
			public Double get() {
				System.out.println("get : " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 5000D;
			}
		};

		Consumer<? super Double> consumerAction = (val) -> {
			System.out.println("thenAcceptAsync : " + Thread.currentThread().getName());
			System.out.println(val);
		};

		CompletableFuture.supplyAsync(supplier, executors).thenAcceptAsync(consumerAction);

		// .thenAccept((val) -> {
		// System.out.println("thenAccept : " +
		// Thread.currentThread().getName());
		// System.out.println(val);
		// });

		// Default threadpools are killed when main is killed
		// Use your own ThreadPool in your program

		System.out.println("main Thread : " + Thread.currentThread().getName());
		System.out.println("main thread is not blocked now");

		// try {
		// Thread.sleep(2000L);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		executors.shutdown();
	}

}
