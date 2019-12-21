package com.yektaanil.lilcache;

import java.io.Serializable;

import com.yektaanil.lilcache.collection.CachePolicy;
import com.yektaanil.lilcache.collection.PolicyFactory;
import com.yektaanil.lilcache.contract.AbstractLilCacheContract;

public class LilCache<K, V> extends AbstractLilCacheContract<K, V> implements Serializable
{

    private static final long serialVersionUID = 8602315778724460754L;
    private boolean isTimerActive;
   
    private AbstractLilCacheContract<K, V> lilCache;
    
    public LilCache(CachePolicy policy, final int maxSize) {
    	lilCache = PolicyFactory.getPolicy(policy, maxSize);
    	
    }
    
    /*  public LilCache(final long cleanUpTimerInSecond, final int maxSize) {
        isTimerActive = true;
        
        
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
    } */
    
    public void put(final K key, final V value) {
    	lilCache.put(key, value);
    }
    

	public V get(final K key) {
		return lilCache.get(key);
    }
    
    public void remove(final K key) {
    	lilCache.remove(key);
    }
    
    public int size() {
		return lilCache.size();  	
    }
    
    public void clear() {
    	lilCache.clear();
    }
    
    public boolean isTimerActive() {
        return this.isTimerActive;
    }
    
    public void setTimerActive(final boolean isTimerActive) {
        this.isTimerActive = isTimerActive;
    }

	public double getHitRatio() {
		return lilCache.getHitRatio();
	}

	public boolean containsKey(K key) {
		return lilCache.containsKey(key);
	}

}