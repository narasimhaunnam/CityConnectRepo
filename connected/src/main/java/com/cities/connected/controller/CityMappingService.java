package com.cities.connected.controller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author narasimha
 *
 *         Adding Cities to Map
 * 
 */
@Component
public class CityMappingService {

	private static final Logger log = LoggerFactory.getLogger(CityMappingService.class);

	/**
	 * All connected cities set to cityMap
	 */
	private static Map<String, LinkedHashSet<String>> cityMap = new HashMap<String, LinkedHashSet<String>>();

	
	/**
	 * @param origin
	 * @param destiantion
	 */
	public void addCities(String origin, String destiantion) {
		LinkedHashSet<String> citySet = cityMap.get(origin);
		if (citySet == null) {
			citySet = new LinkedHashSet<String>();
			cityMap.put(origin, citySet);
		}
		citySet.add(destiantion);
	}

	/**
	 * @param origin
	 * @param destiantion
	 */
	public void twoWayCityMapping(String origin, String destiantion) {
		addCities(origin, destiantion);
		addCities(destiantion, origin);
	}

	/**
	 * @param origin
	 * @param destination
	 * @return String
	 * 		Checks requested origin and destination cities are connected or not
	 * 		If connected returns Yes otherwise No
	 */
	public String isConnected(String origin, String destination) {
		
		Set<?> connecter = cityMap.get(origin);
		String returns = null;
		if (connecter == null) {
			log.info("Cities  : " + origin + " and/or  " + destination + " are not exist ");
		returns = "No";
		}else if (connecter.contains(destination)) {
			log.info("Cities  : " + origin + " and  " + destination + " are connected");
			returns = "Yes";
		} else {
			log.info("Cities  : " + origin + " and  " + destination + " are not connected");
			returns = "No";
		}
		return returns;
	}
}
