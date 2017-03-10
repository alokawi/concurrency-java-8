/**
 * 
 */
package sag.example.java8concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author alokkumar
 *
 */
public class CompletableFutureException {

	public static void main(String[] args) {
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		ReadLock readLock = readWriteLock.readLock();

		readLock.lock();

		// ConcurrentHashMap is based on this optimistic lock??

	}

}
