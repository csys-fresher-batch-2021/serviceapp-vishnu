package in.vishnu.services;

import java.util.ArrayList;
import java.util.List;

public class DisplayServices {
	
	private DisplayServices() {
	    //default constructor
	  }
	
	private static List<String> carServicesList = new ArrayList<>();

	static {
		carServicesList.add("TIRE REPLACEMENT");
		carServicesList.add("BATTERY REPLACEMENT");
		carServicesList.add("BRAKE REPLACEMENT");
		carServicesList.add("SPARK PLUG REPLACEMENT");
		carServicesList.add("WHEEL ALIGNMENT");
		carServicesList.add("AIR FILTER REPLACEMENT");
		carServicesList.add("OIL CHANGE");
		carServicesList.add("OTHER SERVICES");
		
	}

	/**
	 * returns car services list
	 * 
	 * @return
	 */
	public static List<String> getServices() {
		return carServicesList;
	}

}
