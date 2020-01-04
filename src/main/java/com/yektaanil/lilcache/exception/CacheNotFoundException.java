package com.yektaanil.lilcache.exception;

public class CacheNotFoundException extends NullPointerException{

	private static final long serialVersionUID = 1071122522109157023L;

    /**
     * Constructs a {@code CacheNotFoundException} with no detail message.
     */
	public CacheNotFoundException() {
		
	}
	
    /**
     * Constructs a {@code CacheNotFoundException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
	public CacheNotFoundException(String s) {
		super(s);
	}
}
