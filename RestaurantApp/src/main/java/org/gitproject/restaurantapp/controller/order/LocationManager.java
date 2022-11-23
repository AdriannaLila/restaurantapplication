package org.gitproject.restaurantapp.controller.order;

import org.gitproject.restaurantapp.model.Location;


public class LocationManager {

	public static Location getLocationFromString(String locationAsString) {
		for(Location location : Location.values()) {
			if(location.name().equals(locationAsString)) {
				return location;
			}
		}
		
		System.err.println("No location could be found for given parameter");
		return null;
	}
	
}
