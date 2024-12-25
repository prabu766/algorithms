package com.algo.ratelimit;

import java.time.Instant;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class TokenBucket {

	private int currentTokenCount; //Current token count in the bucket
	private int bucketSize; //Capacity of the bucket
	private double fillRate; //Filling rate of the bucket (e.g. 60 tokens per m
	private long refillTimeStamp; //last time of token generated
	 
	
	TokenBucket(int bucketSize,double fillRate){
		this.bucketSize =  bucketSize;
		this.fillRate =  fillRate;
		this.refillTimeStamp = Instant.now().toEpochMilli();
	}
	
	public synchronized boolean allow(int tokensNeed) {
		refillGreedy();
		if(currentTokenCount > tokensNeed ) {
			currentTokenCount -= tokensNeed;
			return true;
		}
		return false;
	}
	
	private void refillGreedy() {
		long now = Instant.now().toEpochMilli();
		long elapsedTime = now - refillTimeStamp;
		int tokensToAdd = (int) (elapsedTime * fillRate);
		currentTokenCount = Math.min(bucketSize, currentTokenCount+ tokensToAdd);
		refillTimeStamp = now;
	}
	
}
