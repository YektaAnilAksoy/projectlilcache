package com.yektaanil.lilcache;

import com.yektaanil.lilcache.entity.LilCachiableObject;
import java.lang.ref.SoftReference;
import org.apache.commons.collections4.map.LRUMap;
import java.io.Serializable;

import com.yektaanil.lilcache.contract.AbstractLilCacheContract;

public class LilCache<K, V> extends AbstractLilCacheContract<K, V> implements Serializable
{

    private static final long serialVersionUID = 8602315778724460754L;
    private boolean isTimerActive;
    private LRUMap<K, SoftReference<LilCachiableObject<V>>> lilCacheMap;
    
    public LilCache(final long cleanUpTimerInSecond, final int maxSize) {
        isTimerActive = true;
        lilCacheMap = new LRUMap<K, SoftReference<LilCachiableObject<V>>>(maxSize);
        
        if (cleanUpTimerInSecond > 0L) {
            final long cleanUpTimerInMilliSecond = cleanUpTimerInSecond * 1000L;
            final Thread cleanerCaller = new Thread(new Runnable() {
            	public void run() {
            		try {
            			Thread.sleep(cleanUpTimerInMilliSecond);
            		} catch(InterruptedException ex) {
            			ex.printStackTrace();
            		}
            		clear();
            	}
            });
            cleanerCaller.setDaemon(true);
            cleanerCaller.start();
        }
    }
    
    public void put(final K key, final V value) {
        synchronized (lilCacheMap) {
            lilCacheMap.put(key, new SoftReference<LilCachiableObject<V>>(new LilCachiableObject<V>(value)));
        }

    }
    
    @SuppressWarnings("unchecked")
	public V get(final K key) {
        synchronized (lilCacheMap) {
            final SoftReference<LilCachiableObject<V>> lilCache = (SoftReference<LilCachiableObject<V>>)this.lilCacheMap.get(key);
            
            if (lilCache == null) {
                return null;
            }
            
            lilCache.get().setLastAccessed(System.currentTimeMillis());
            final Object value = lilCache.get().getValue();

            return (V)value;
        }
    }
    
    public void remove(final K key) {
        synchronized (lilCacheMap) {
            lilCacheMap.remove(key);
        }

    }
    
    public int size() {
        synchronized (lilCacheMap) {
            return lilCacheMap.size();
        }
    }
    
    public void clear() {
    }
    
    public boolean isTimerActive() {
        return this.isTimerActive;
    }
    
    public void setTimerActive(final boolean isTimerActive) {
        this.isTimerActive = isTimerActive;
    }

	public double getHitRatio() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

}