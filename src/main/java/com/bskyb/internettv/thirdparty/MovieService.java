package com.bskyb.internettv.thirdparty;

 

/**
 * 
 * @author maxp
 *
 */
public interface MovieService {
	/**
	 * 
	 * @param movieId
	 * @return
	 * @throws TitleNotFoundException
	 * @throws TechnicalFailureException
	 */
	String getParentalControlLevel(String titleId) throws TitleNotFoundException, TechnicalFailureException;
}