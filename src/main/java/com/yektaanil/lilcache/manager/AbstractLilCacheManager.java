package com.yektaanil.lilcache.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.yektaanil.lilcache.LilCache;

/**
 * 
 * @author Yekta Anil Aksoy
 *
 */
public abstract class AbstractLilCacheManager implements CacheManager {

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
	
	/**
	 * Checks whether the cache manager has the cache or not
	 * 
	 * @param cacheName indicates the related cache.
	 * 
	 * @return true if the cache manager contains the cache; otherwise false.
	 */
	@Override
	public boolean containsCache(String cacheName) {
		return cacheMap.containsKey(cacheName);
	}
	
	/**
	 * Removes the cache related with the given cacheName.
	 * It should be kept in mind that when this method runs, it destroys
	 * all caches in the cache manager.
	 * This operation cannot be undone.
	 */
	@Override
	public void removeAll() {
		String[] cacheNames = getCacheNames();
		for(String cacheName : cacheNames) {
			removeCache(cacheName);
		}
	}
	
	/**
	 * Removes the cache related with the given cacheName from the cache manager.
	 * 
	 * @param cacheName indicates the related cache.
	 */
	@Override
	public void removeCache(String cacheName) {
		
	}
	
	/**
	 * Clears all the caches inside the manager.
	 */
	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Clears the cache associated with given cacheName
	 * 
	 * @param cacheName indicates the related cache.
	 */
	@Override
	public void clearCache(String cacheName) {
		cacheMap.get(cacheName).clear();
	}
	
	
}
