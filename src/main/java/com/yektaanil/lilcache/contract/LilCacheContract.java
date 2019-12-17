package com.yektaanil.lilcache.contract;

public interface LilCacheContract<K, V>
{
    void put(final K p0, final V p1);
    
    V get(final K p0);
    
    void remove(final K p0);
    
    int size();
    
    void cleanUp();
}