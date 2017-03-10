/**
 * 
 */
package sag.example.java8concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @author alokkumar
 *
 */
public class AcceptEitherFuture {

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(5);

		CompletableFuture<Double> thenAcceptAsync1 = CompletableFuture.supplyAsync(new Supplier<Double>() {

			@Override
			public Double get() {
				System.out.println("get : " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 1000D;
			}
		}, executors);

		CompletableFuture<Double> thenAcceptAsync2 = CompletableFuture.supplyAsync(new Supplier<Double>() {

			@Override
			public Double get() {
				System.out.println("get : " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 2000D;
			}
		}, executors);

		thenAcceptAsync1.acceptEither(thenAcceptAsync2, (val) -> {
			System.out.println("val :  " + val);
		});

		executors.shutdown();

	}

}
