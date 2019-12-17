package com.yektaanil.projectlilcache;


import com.yektaanil.lilcache.LilCache;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for LilCache.
 */
public class AppTest extends TestCase
{

	protected LilCache<String, Integer> cache;
	
	/**
	 * Creates a cache structure and fills it, before testing it
	 */
	protected void setUp() 
	{
		System.out.println("Setting it up! ");
		cache = new LilCache<String, Integer>(5, 3);
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
       assertEquals(Integer.valueOf(1), cache.get("user1"));
       assertEquals(Integer.valueOf(2), cache.get("user2"));
       assertEquals(Integer.valueOf(3), cache.get("user3"));
    }

    
    public void testLeastRecentlyUsedAlgorithm()
    {
    	cache.put("user4", 4);
    	assertEquals(null,cache.get("user1"));
    }
    

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

}
