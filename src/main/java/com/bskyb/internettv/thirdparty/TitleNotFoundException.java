package com.bskyb.internettv.thirdparty;

/**
 * 
 * @author maxp
 *
 */
public class TitleNotFoundException extends Exception {
   
	private static final long serialVersionUID = 1L;

	/***
	 * 
	 * @param message
	 * @param cause
	 */
	public TitleNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
	
	/**
	 * 
	 * @param message
	 */
	public TitleNotFoundException(String message) {
        super(message);
    }
}
