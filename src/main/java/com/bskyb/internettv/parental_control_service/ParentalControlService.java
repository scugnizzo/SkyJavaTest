package com.bskyb.internettv.parental_control_service;

import com.bskyb.internettv.thirdparty.LevelNotFoundException;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

/**
 * 
 * @author maxp
 *
 */
public interface ParentalControlService {
	
	/***
	 * 
	 * @param movieId
	 * @param customerParentalControlLevelPreference
	 * @return
	 * @throws TechnicalFailureException
	 * @throws TitleNotFoundException
	 */
	boolean canWatchMovie(String customerParentalControlLevel, String movieId) throws LevelNotFoundException, 
	TechnicalFailureException, TitleNotFoundException;
}
