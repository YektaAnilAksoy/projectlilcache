package com.yektaanil.lilcache.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yektaanil.lilcache.contract.AbstractLilCacheContract;

public class PolicyFactory<K, V> {

	private static final Logger LOG = LoggerFactory.getLogger(PolicyFactory.class);
	
	public static <K, V> AbstractLilCacheContract<K, V> getPolicy(CachePolicy policy,int maxSize) {

		switch (policy) {
		case FIFO:
			return new ConcurrentFIFOMap<K, V>(maxSize);
		case LRU:
			return new ConcurrentLRUMap<K, V>(maxSize);
		default:
			break;
		}
		LOG.warn("Unknown Cache Policy - "+policy);
		return null;
	}
}
