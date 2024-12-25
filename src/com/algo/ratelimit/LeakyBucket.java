package com.algo.ratelimit;

import java.time.Instant;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class LeakyBucket {
	private int currentTokenCount; //Current token count in the bucket
	private int bucketSize; //Capacity of the bucket
	private double leakRate; //Filling rate of the bucket (e.g. 60 tokens per m
	private long refillTimeStamp; //last time of token generated
	 
	LeakyBucket(int bucketSize,double fillRate){
		this.bucketSize =  bucketSize;
		this.leakRate =  fillRate;
		this.refillTimeStamp = Instant.now().toEpochMilli();
	}
	
	public synchronized boolean allow(int tokensNeed) {
		leakGreedy();
		if((currentTokenCount +tokensNeed) > bucketSize ) {
			return false;
		}
		return true;
	}
	
	/**
	 * Time interval based refill. This means, do not generate more tokens till it comes to the exact time interval
	 */
	private void refillBasedOnTimeInterval() {
		
	}
	
	private void leakGreedy() {
		long now = Instant.now().toEpochMilli();
		long elapsedTime = now - refillTimeStamp;
		int tokensToLeak = (int) (elapsedTime * leakRate);
		currentTokenCount = Math.max(bucketSize, currentTokenCount - tokensToLeak);
	}

}
