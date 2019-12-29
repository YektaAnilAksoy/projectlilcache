package com.yektaanil.lilcache.manager;

import com.yektaanil.lilcache.LilCache;

/**
 * 
 * @author Yekta Anil Aksoy
 *
 */
public interface CacheManager {

	/**
	 * 
	 * @param cacheName the cache identifier
	 * @return the related cache, or {@code null} if it is non exist.
	 */
	LilCache<?, ?> getCache(String cacheName);
	
	/**
	 * 
	 * @return the names of the caches in the cache manager
	 */
	String[] getCacheNames();
	
	/**
	 * 
	 * @param cacheName the cache identifier
	 * @return a boolean value that indicates whether the cache exists
	 * in the manager or not.
	 */
	boolean containsCache(String cacheName);
	
	void removeAll();
	
	void removeCache(String cacheName);
	
	void clearAll();
	
	void clearCache(String cacheName);
	
	
}
