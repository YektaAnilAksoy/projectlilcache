package com.yektaanil.lilcache.contract;

public abstract class AbstractLilCacheContract<K, V> implements LilCacheContract<K, V> {

	private long numOfHits = 0;
	private long numOfCalls = 0;
	private boolean isNullValueAllowed = true;
	
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

	public boolean isNullValueAllowed() {
		return isNullValueAllowed;
	}

	public void setNullValueAllowed(boolean isNullValueAllowed) {
		this.isNullValueAllowed = isNullValueAllowed;
	}
    
    
}
