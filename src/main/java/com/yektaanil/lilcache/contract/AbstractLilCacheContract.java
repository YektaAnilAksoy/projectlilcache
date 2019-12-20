package com.yektaanil.lilcache.contract;

public abstract class AbstractLilCacheContract<K, V> implements LilCacheContract<K, V> {

	private long numOfHits = 0;
	private long numOfCalls = 0;
	
	public double getHitRatio() {
		
		return (double) numOfHits  / numOfCalls;
		
	}
	  
    public void incrementNumOfHits() {
    	
    	synchronized(this) {
    		numOfHits++;
    	}
    	
    }
    
    public void incrementNumOfCalls() {
    	
    	synchronized(this) {
    		numOfCalls++;
    	}
    	
    }
    
}
