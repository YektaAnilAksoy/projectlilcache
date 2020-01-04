package com.yektaanil.lilcache.manager;

/**
 * LilCacheManager is a synchronized singleton class to manage the caches.
 * 
 * @author Yekta Anil Aksoy
 *
 */
public class LilCacheManager extends AbstractLilCacheManager {

	/**
	 * The shared singleton cache manager.
	 */
	private static volatile LilCacheManager singleton;

	/**
	 * Private constructor in order not to be created of its instance.
	 */
	private LilCacheManager() {

	}

	/**
	 * 
	 * @returns the shared singleton cache manager.
	 */
	synchronized public static LilCacheManager getInstance() {
		if (singleton == null) {
			// if instance is null, initialize
			singleton = new LilCacheManager();
		}
		return singleton;
	}

}
