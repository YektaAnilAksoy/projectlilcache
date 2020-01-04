package com.yektaanil.lilcache.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yektaanil.lilcache.LilCache;
import com.yektaanil.lilcache.collection.CachePolicy;
import com.yektaanil.lilcache.collection.PolicyFactory;
import com.yektaanil.lilcache.manager.LilCacheManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for LilCache.
 */
public class ConcurrentLRUMapTest extends TestCase
{

	protected LilCache<String, Integer> cache;
	private static final Logger LOG = LoggerFactory.getLogger(PolicyFactory.class);
	
	/**
	 * Creates a cache structure and fills it, before testing it
	 */
	protected void setUp() 
	{
		//LilCacheManager cacheManager = LilCacheManager.getInstance();
		
		LOG.info("Test LRU Cache with maxSize: 3 is getting filled up with 3 items...");
		cache = new LilCache("LRUCache",CachePolicy.LRU,3);
        cache.put("user1", 1);
        cache.put("user2", 2);
        cache.put("user3", 3);
	}
	
	/**
	 * Tests the correctness of the values in the cache when
	 * there is no override operation in it
	 */
    public void testGetCachedObjectWhenThereIsNoOverride()
    {
	    LOG.info("Test LRU Cache is getting tested when there is NO OVERRIDE...");
	    assertEquals(Integer.valueOf(1), cache.get("user1"));
	    assertEquals(Integer.valueOf(2), cache.get("user2"));
	    assertEquals(Integer.valueOf(3), cache.get("user3"));
    }

    /**
     * Tests the replacement operation when
     * the cache is full.
     */
    public void testOverrideWhenCacheIsFull()
    {
    	LOG.info("Test LRU Cache is getting tested when there is OVERRIDE...");
    	cache.put("user4", 4);
    	assertEquals(null,cache.get("user1"));
    }
    
    /**
     * Tests whether the cache exceeds the maximum size.
     */
    public void testMaximumSize()
    {
    	LOG.info("Test LRU Cache has 3 items before maxSize test...");
    	cache.put("user4", 4);
    	LOG.info("1 item is added to Test LRU Cache...");
    	assertEquals(null,cache.get("user1"));
    	LOG.info("After add operation, size of the cache is: " + cache.size());
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ConcurrentLRUMapTest.class );
    }

}
