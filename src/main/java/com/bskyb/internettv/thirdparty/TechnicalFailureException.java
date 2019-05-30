package com.bskyb.internettv.thirdparty;

/**
 * 
 * @author maxp
 *
 */
public class TechnicalFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
    public TechnicalFailureException(String message){
        super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public TechnicalFailureException(String message, Throwable cause){
        super(message, cause);
    }

}

