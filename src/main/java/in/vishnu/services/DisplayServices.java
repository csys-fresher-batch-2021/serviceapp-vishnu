package in.vishnu.services;

import java.util.ArrayList;
import java.util.List;

public class DisplayServices {

	private static List<String> carServicesList = new ArrayList<String>();

	static {
		carServicesList.add("TIRE REEPLACEMENT");
		carServicesList.add("BATTERY REPLACEMENT");
		carServicesList.add("BRAKE REPLACEMENT");
		carServicesList.add("SPARK PLUG REPLACEMENT");
		carServicesList.add("WHEEL ALIGNMENT");
		carServicesList.add("AIR FILTER REPLACEMENT");
		carServicesList.add("OIL CHANGE");
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
