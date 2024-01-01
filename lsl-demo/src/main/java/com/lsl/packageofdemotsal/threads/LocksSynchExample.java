package com.lsl.packageofdemotsal.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LocksSynchExample {

	public static void main(String[] args) throws Exception,InterruptedException {
		// TODO Auto-generated method stub
		
		
		ReentrantLock lockObj = new ReentrantLock();
		Condition condition = lockObj.newCondition();
		
		lockObj.lock();
		try {
			// Critical section
			condition.await();
		} finally {
			lockObj.unlock(); // Release the lock
		}
		
		
		
		try (AutoCloseable ignored = lockObj::lock) {
		     // Critical section
		 }
		
		
		
		
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Lock readLock = readWriteLock.readLock();
			
		readLock.lock();
		try {
			// Read operation
		} finally {
			readLock.unlock();
		}


	}

}
