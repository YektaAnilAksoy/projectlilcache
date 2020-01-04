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
	
	/**
	 *
	 * @param cacheName the cache identifier
	 * @param cache is the cache structure that holds keys and values.
	 * Note that if the {@code cacheName} is not absent, then it will be overridden!
	 */
	void addCache(String cacheName, LilCache<?, ?> cache);
	
	/**
	 * Removes the cache related with the given cacheName.
	 * It should be kept in mind that when this method runs, it destroys
	 * all caches in the cache manager.
	 * This operation cannot be undone.
	 */
	void removeAll();
	
	/**
	 * Removes the cache related with the given cacheName from the cache manager.
	 * 
	 * @param cacheName indicates the related cache.
	 */
	void removeCache(String cacheName);
	
	/**
	 * Clears all the caches inside the manager.
	 */
	void clearAll();
	
	/**
	 * Clears the cache associated with given cacheName
	 * 
	 * @param cacheName indicates the related cache.
	 */
	void clearCache(String cacheName);
	
	
}
