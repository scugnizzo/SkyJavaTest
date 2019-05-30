package com.bskyb.internettv.thirdparty.util;

import java.util.HashMap;
import java.util.Map;

import com.bskyb.internettv.thirdparty.LevelNotFoundException;

/**
 * 
 * @author maxp
 *
 */
public enum LevelControl {
	 U(0, "U"), PG(1, "PG"), VM_12(2, "12"), VM_15(3, "15"), VM_18(4, "18");

	 	public final static Map<String, LevelControl> ratingMap = new HashMap<>();
	 	static {
	        for (LevelControl rating : LevelControl.values()) {
	            ratingMap.put(rating.stringValue, rating);
	        }
	    }

	    private final int value;
	    private final String stringValue;

	    /**
	     * 
	     * @param intValue
	     * @param stringValue
	     */
	    LevelControl(int intValue, String stringValue) {
	        this.value = intValue;
	        this.stringValue = stringValue;
	    }

	    /**
	     * 
	     * @param pcl
	     * @return
	     * @throws LevelNotFoundException
	     */
	    public static LevelControl getLevelControl(int key) throws LevelNotFoundException{
			try {
			
				LevelControl pclFound = ratingMap.get(key);
				return pclFound;
			
			} catch (IllegalArgumentException e) {
				throw new LevelNotFoundException(key + " , it is not listed as a Parental Control Level. It should be one of the following: ", e);
			}
		}
	    
	    /**
	     * 
	     * @param rating
	     * @return
	     */
	    public static LevelControl getByString(String rating) {
	        return ratingMap.get(rating);
	    }

	    /**
	     * 
	     * @return
	     */
	    public int getValue() {
	        return value;
	    }
}
