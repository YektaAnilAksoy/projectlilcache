package com.yektaanil.lilcache.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yektaanil.lilcache.LilCache;
import com.yektaanil.lilcache.collection.PolicyFactory;
import com.yektaanil.lilcache.exception.CacheNotFoundException;


/**
 * 
 * @author Yekta Anil Aksoy
 *
 */
public abstract class AbstractLilCacheManager implements CacheManager {

	private static final Logger LOG = LoggerFactory.getLogger(PolicyFactory.class);
	
	/**
	 * cacheMap keeps all the alive caches inside it.
	 */
	private final ConcurrentMap<String,LilCache<?,?>> cacheMap = new ConcurrentHashMap<String, LilCache<?, ?>>(16);

	/**
	 * @param cacheName indicates the related cache.
	 * @return the cache by cacheName.
	 */
	@Override
	public LilCache<?, ?> getCache(String cacheName) {
		
		LilCache<?, ?> cache = this.cacheMap.get(cacheName);

		return cache;
	}
	
	/**
	 * @return the names of the caches in the cache manager
	 */
	@Override
	public String[] getCacheNames() {
		String[] cacheNameArray = new String[cacheMap.size()];
		return cacheMap.keySet().toArray(cacheNameArray);
	}
	
	@Override
	public boolean containsCache(String cacheName) {
		return cacheMap.containsKey(cacheName);
	}
	
	@Override
	public void removeAll() {
		String[] cacheNames = getCacheNames();
		for(String cacheName : cacheNames) {
			removeCache(cacheName);
		}
	}
	
	@Override
	public void removeCache(String cacheName) {
		
	}
	
	@Override
	public void addCache(String cacheName, LilCache<?, ?> cache) {
		LOG.info("A cache with name: "+cacheName+" is added to the cache manager.");
		cacheMap.put(cacheName, cache);
	}
	

	@Override
	public void clearAll() {
		String[] cacheNames = getCacheNames();
		
		synchronized (cacheMap) {
			for(String name : cacheNames) {
				clearCache(name);
				LOG.info("Cache -"+name+"- is successfully cleared.");
			}
		}
	}
	
	@Override
	public void clearCache(String cacheName) {
		synchronized (cacheMap) {
			if(containsCache(cacheName)) {
				cacheMap.get(cacheName).clear();
			}
			else {
				throw new CacheNotFoundException("There is no cache in the cache manager with provided cache name - " + cacheName);
			}
		}
	}
}
