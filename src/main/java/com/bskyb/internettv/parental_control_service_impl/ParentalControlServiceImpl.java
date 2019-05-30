package com.bskyb.internettv.parental_control_service_impl;

import com.bskyb.internettv.parental_control_service.ParentalControlService;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;
import com.bskyb.internettv.thirdparty.util.LevelControl;
import com.bskyb.internettv.thirdparty.util.MsgError;
 

/**
 * 
 * @author maxp
 *
 */
public class ParentalControlServiceImpl implements ParentalControlService {

	final private MovieService movieService;
	
	 
	
	
    /**
     * 
     * @param movieService
     * @throws TechnicalFailureException
     */
    public ParentalControlServiceImpl(MovieService movieService) throws TechnicalFailureException {
        if (movieService == null) {
            throw new TechnicalFailureException(MsgError.NULLABLE_MOVE);
        }
        this.movieService = movieService;
    }

     
 
    /***
     * 
     * @param customerParentalControlLevelPreference
     * @return
     * @throws TechnicalFailureException
     * Currently case sensitive.
     */
    private int getIntRepresentationOfParentalControlLevel(String customerParentalControlLevelPreference) throws TechnicalFailureException {
        switch (customerParentalControlLevelPreference) {
            case "U":
                return LevelControl.U.getValue();
            case "PG":
                return LevelControl.PG.getValue();
            case "12":
                return LevelControl.VM_12.getValue();
            case "15":
                return LevelControl.VM_15.getValue();
            case "18":
                return LevelControl.VM_18.getValue();
            default:
                throw new TechnicalFailureException(MsgError.UNKNOW_LEVELG + customerParentalControlLevelPreference);
        }
    }

    /***
     * 
     * @param movieId
     * @return
     * @throws TechnicalFailureException
     * @throws TitleNotFoundException
     */
    private String getParentalControlLevel(String movieId) throws TechnicalFailureException, TitleNotFoundException {
    	
        try {
        
        	String controlLevel = movieService.getParentalControlLevel(movieId);
            if (controlLevel != null) {
                return controlLevel;
            } else {
                throw new TechnicalFailureException(MsgError.INVALID_LEVEL);
            }
        } catch (TechnicalFailureException | TitleNotFoundException ex) {
        	 /**
        	  * Do some logging here
        	  * */
            throw ex;
        } catch (Exception ex) {
            /**
             * MovieService behaving badly, ie runtime exceptionz
             * Do some logging here
            */
        	throw new TechnicalFailureException(MsgError.INTER_ERR, ex);
        }
    }

 
    @Override
	public boolean canWatchMovie(String movieId, String customerParentalControlLevelPreference)	throws TechnicalFailureException, TitleNotFoundException {
		 
    	final String movieControlLevel = getParentalControlLevel(movieId);
	    return getIntRepresentationOfParentalControlLevel(movieControlLevel) <= getIntRepresentationOfParentalControlLevel(customerParentalControlLevelPreference);
	}

}

