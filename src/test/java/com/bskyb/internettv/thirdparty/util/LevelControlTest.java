package com.bskyb.internettv.thirdparty.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.bskyb.internettv.parental_control_service.ParentalControlService;
import com.bskyb.internettv.parental_control_service_impl.ParentalControlServiceImpl;
import com.bskyb.internettv.thirdparty.LevelNotFoundException;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

@RunWith(JUnit4.class)
public class LevelControlTest {
	
	private MovieService movieService;

	@Before
	  public void init() throws TechnicalFailureException, TitleNotFoundException {

        
	}

	@Test
	public void testGetByString() throws LevelNotFoundException {
		
		Assert.assertNotEquals("12 should not be mapped to ", 12,  LevelControl.VM_18.getValue());
		Assert.assertSame("PG should be mapped to " + 1, 1 , LevelControl.PG.getValue());
	}

	
	@Test
    public void testTheStringsExpectedByTheMovieServiceAreAssociatedCorrectlyWithOurEnums() throws Exception {
		Assert.assertEquals(LevelControl.U, LevelControl.getByString("U"));
        Assert.assertEquals(LevelControl.PG, LevelControl.getByString("PG"));
        Assert.assertEquals(LevelControl.VM_12, LevelControl.getByString("12"));
        Assert.assertEquals(LevelControl.VM_15, LevelControl.getByString("15"));
        Assert.assertEquals(LevelControl.VM_18, LevelControl.getByString("18"));
    }
	 
	
	 @Test
	    public void testTheIntegerAssociatedToTheEnumAreCorrect() throws Exception {
	        Assert.assertEquals(0, LevelControl.U.getValue());
	        Assert.assertEquals(1, LevelControl.PG.getValue());
	        Assert.assertEquals(2, LevelControl.VM_12.getValue());
	        Assert.assertEquals(3, LevelControl.VM_15.getValue());
	        Assert.assertEquals(4, LevelControl.VM_18.getValue());
	    }
	 
	  

}
