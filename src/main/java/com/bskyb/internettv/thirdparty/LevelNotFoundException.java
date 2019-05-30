package com.bskyb.internettv.thirdparty;

/**
 * 
 * @author maxp
 *
 */
public class LevelNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param message
	 * @param reason
	 */
	public LevelNotFoundException(String message, Throwable reason) {
        super(message, reason);
    }
	
	/**
	 * 
	 * @param message
	 */
	public LevelNotFoundException(String message) {
        super(message);
    }
}
