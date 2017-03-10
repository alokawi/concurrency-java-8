/**
 * 
 */
package sag.example.java8concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * @author alokkumar
 *
 */
public class CustomCompletableFuture {

	public static CompletableFuture<String> getWebPages(String url, ExecutorService executorService) {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();

		Runnable task = () -> {

		};

		executorService.submit(task);

		return completableFuture;
	}

}