package com.yektaanil.lilcache.collection;

import java.io.Serializable;
import java.lang.ref.SoftReference;


import org.apache.commons.collections4.map.LRUMap;

import com.yektaanil.lilcache.contract.AbstractLilCacheContract;
import com.yektaanil.lilcache.entity.LilCachiableObject;

class ConcurrentLRUMap<K, V> extends AbstractLilCacheContract<K, V> implements Serializable, Cloneable {

	private static final long serialVersionUID = 3502940324176031946L;
	
	private LRUMap<K, SoftReference<LilCachiableObject<V>>> lruMap;
	
	public ConcurrentLRUMap(final int maxSize) {
		lruMap = new LRUMap<K, SoftReference<LilCachiableObject<V>>>(maxSize);
	}
	
	public void put(final K key, final V value) {
        synchronized (lruMap) {
        	lruMap.put(key, new SoftReference<LilCachiableObject<V>>(new LilCachiableObject<V>(value)));
        }

	}


	public V get(final K key) {     
		synchronized (lruMap) {
        	super.incrementNumOfCalls();
            final SoftReference<LilCachiableObject<V>> cachedData = (SoftReference<LilCachiableObject<V>>)this.lruMap.get(key);
            
            if (cachedData == null) {
                return null;
            }
            
            super.incrementNumOfHits();
            
            cachedData.get().setLastAccessed(System.currentTimeMillis());         
            final V value = cachedData.get().getValue();

            return value;
        }
	}

	public void remove(final K key) {
        synchronized (lruMap) {
        	lruMap.remove(key);
        }
	}

	public int size() {
        synchronized (lruMap) {
            return lruMap.size();
        }
	}

	public boolean containsKey(final K key) {
		synchronized (lruMap) {
			return lruMap.containsKey(key);
		}
	}

	public void clear() {
		synchronized (lruMap) {
			lruMap.clear();
		}
		
	}

}
