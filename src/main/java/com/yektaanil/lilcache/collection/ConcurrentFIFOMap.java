package com.yektaanil.lilcache.collection;


import com.yektaanil.lilcache.contract.AbstractLilCacheContract;

class ConcurrentFIFOMap<K, V> extends AbstractLilCacheContract<K, V>{

	private FIFOMap<K, V> fifoMap;
	
	
	public ConcurrentFIFOMap(int maxSize) {
		fifoMap = new FIFOMap<K,V>(maxSize);
	}
	
	public void put(K key, V value) {
		synchronized(fifoMap) {
			fifoMap.put(key, value);
		}
	}

	public V get(K key) {
		synchronized(fifoMap) {
			return fifoMap.get(key);
		}
	}

	public void remove(K key) {
		synchronized (fifoMap) {
			fifoMap.remove(key);
		}
		
	}

	public int size() {
		return fifoMap.size();
	}

	public boolean containsKey(K key) {
		
		return fifoMap.containsKey(key);
	}

	public void clear() {
		synchronized(fifoMap) {
			fifoMap.clear();
		}
	}

}
