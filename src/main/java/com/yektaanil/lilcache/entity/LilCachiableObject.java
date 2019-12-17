package com.yektaanil.lilcache.entity;

import java.io.Serializable;

public class LilCachiableObject<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long lastAccessed;
    private T value;
    
    public LilCachiableObject(final T value) {
        this.value = value;
        this.lastAccessed = System.currentTimeMillis();
    }
    
    public long getLastAccessed() {
        return this.lastAccessed;
    }
    
    public void setLastAccessed(final long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
    
    public T getValue() {
        return this.value;
    }
    
    public void setValue(final T value) {
        this.value = value;
    }
}