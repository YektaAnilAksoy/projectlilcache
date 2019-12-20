package com.yektaanil.lilcache.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOMap<K, V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = -225178825525370195L;

	private final int maxSize;
	private static final byte DEFAULT_MAX_SIZE = 32;
	
    public FIFOMap() {        
        this(DEFAULT_MAX_SIZE);
    }

    public FIFOMap(final int arg0) {
        this(arg0, 0.75f);
    }

    public FIFOMap(final int arg0, final float arg1) {
        this(arg0, arg1, true);
    }

    public FIFOMap(final int arg0, final float arg1, final boolean arg2) throws RuntimeException {
        super(arg0 + 1, arg1, arg2);
        if (!arg2) {
            throw new RuntimeException("Error instantiating fixed size fifo Map!");
        }
        maxSize = arg0;
    }

    public FIFOMap(final Map<K, V> arg0) throws RuntimeException {
        throw new RuntimeException("Error instantiating fixed size FIFO Map!");
    }
	
    @Override
    public boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
