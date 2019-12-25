package com.yektaanil.lilcache.entity;

import java.io.Serializable;

public class LilCachiableObject<V> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long lastAccessed;
    private V value;
    
    public LilCachiableObject(final V value) {
        this.value = value;
        this.lastAccessed = System.currentTimeMillis();
    }
    
    public long getLastAccessed() {
        return this.lastAccessed;
    }
    
    private void setLastAccessed(final long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
    
    public V getValue() {
    	setLastAccessed(System.currentTimeMillis());
        return this.value;
    }
    
    public void setValue(final V value) {
        this.value = value;
    }
}