package com.yektaanil.lilcache.collection;

import com.yektaanil.lilcache.contract.AbstractLilCacheContract;

public class PolicyFactory<K, V> {

	public AbstractLilCacheContract<K, V> getPolicy(CachePolicy policy,int maxSize) {

		switch (policy) {
		case FIFO:
			return new ConcurrentFIFOMap<K, V>(maxSize);
		default:
			break;
		}
		return null;
	}
}
