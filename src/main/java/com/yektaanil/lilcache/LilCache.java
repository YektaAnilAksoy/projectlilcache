package com.yektaanil.lilcache;

import java.io.Serializable;
import java.util.Objects;

import com.yektaanil.lilcache.collection.CachePolicy;
import com.yektaanil.lilcache.collection.PolicyFactory;
import com.yektaanil.lilcache.contract.AbstractLilCacheContract;
import com.yektaanil.lilcache.entity.LilCacheConfiguration;
import com.yektaanil.lilcache.entity.LilCachiableObject;

/**
 * LilCache is a controller class that keeps the logic inside it for 
 * various cache algorithms @see {@code ConcurrentFIFOMap} {@code ConcurrentLFUMap} {@code ConcurrentLRUMap}
 * 
 * @author Yekta Anil Aksoy
 * @param <K> key
 * @param <V> value
 */
public final class LilCache<K, V> extends AbstractLilCacheContract<K, V> implements Serializable
{

    private static final long serialVersionUID = 8602315778724460754L;
    private AbstractLilCacheContract<K, LilCachiableObject<V>> lilCache;
    private LilCacheConfiguration configuration;
    
    /**
     * @param cacheName the cache identifier (must not be {@code null})
     * @param policy indicates the replacement algorithm
     * @throws {@code NullPointerException} if cacheName is null.
     */
    public LilCache(final String cacheName,final CachePolicy policy, final int maxSize) {
    	//configuration.setCacheName(Objects.requireNonNull(cacheName));
    	//configuration.setPolicy(policy);
    	//configuration.setMaxSize(maxSize);
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
    	lilCache.put(key, new LilCachiableObject<V>(value));
    }
    

	public V get(final K key) {
		lilCache.incrementNumOfCalls();
		
		final LilCachiableObject<V> cachedData = lilCache.get(key);
		
		if(cachedData != null) {
			lilCache.incrementNumOfHits();
			return cachedData.getValue();
		}
		return null;
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
    
	public double getHitRatio() {
		return lilCache.getHitRatio();
	}

	public boolean containsKey(K key) {
		return lilCache.containsKey(key);
	}

	public LilCacheConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(LilCacheConfiguration cacheConfig) {
		this.configuration = cacheConfig;
	}
	
}