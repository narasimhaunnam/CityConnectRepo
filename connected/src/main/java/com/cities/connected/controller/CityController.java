/**
 * 
 */
package com.cities.connected.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author narasimha
 *
 */
@RestController
public class CityController {

	private static final Logger log = LoggerFactory.getLogger(CityController.class);

	@Autowired
	private CityMappingService cityService;

	@RequestMapping("/connected")
	public String checkConnected(@RequestParam(value = "origin") String origin,
			@RequestParam(value = "destination") String destination) throws IOException {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(CityController.class.getClassLoader().getResourceAsStream("city.txt")));

				Stream<String> lines = br.lines()) {
			lines.forEach((string) -> {
				String[] str = string.split(",");
				cityService.twoWayCityMapping(str[0].trim(), str[1].trim());

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("Input request --> origin is : " + origin + " and destination is :" + destination);
		return cityService.isConnected(origin.trim(), destination.trim());
	}
}
