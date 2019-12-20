package com.yektaanil.lilcache.contract;

public interface LilCacheContract<K, V>
{	
    void put(final K key, final V value);
    
    V get(final K key);
    
    void remove(final K key);
    
    int size();
    
    boolean containsKey(final K key);
    
    void clear();
}