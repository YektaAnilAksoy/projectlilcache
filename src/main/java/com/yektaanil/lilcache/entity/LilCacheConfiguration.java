package com.yektaanil.lilcache.entity;

import com.yektaanil.lilcache.collection.CachePolicy;

public final class LilCacheConfiguration implements Cloneable {

	private boolean isTimeToLiveActive;
	private boolean isNullValueAllowed = true;
	private String cacheName;
	private boolean isTimerActive;
	private CachePolicy policy;
	private int maxSize = 16;
	
	public LilCacheConfiguration() {
	}
	
	public boolean isTimeToLiveActive() {
		return isTimeToLiveActive;
	}
	
	public void setTimeToLiveActive(boolean isTimeToLiveActive) {
		this.isTimeToLiveActive = isTimeToLiveActive;
	}
	
	public boolean isNullValueAllowed() {
		return isNullValueAllowed;
	}
	
	public void setNullValueAllowed(boolean isNullValueAllowed) {
		this.isNullValueAllowed = isNullValueAllowed;
	}
	
	public String getCacheName() {
		return cacheName;
	}
	
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public boolean isTimerActive() {
		return isTimerActive;
	}

	public void setTimerActive(boolean isTimerActive) {
		this.isTimerActive = isTimerActive;
	}

	public CachePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(CachePolicy policy) {
		this.policy = policy;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}	
	
	
	
	
	
}
