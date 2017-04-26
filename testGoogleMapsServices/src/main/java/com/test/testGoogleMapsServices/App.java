package com.test.testGoogleMapsServices;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	static private Logger LOG;

	public static void main(String[] args) {
		LOG = LoggerFactory.getLogger(App.class);
		LOG.info("Hello World");
		App app = new App();
		app.updateLatLng("London");
	}

	public void updateLatLng(String address) {
		String googleMapsKey = "YOUR_API_KEY_HERE";
		LOG.info("Creating context");
		GeoApiContext context = new GeoApiContext().setApiKey(googleMapsKey);
		LOG.info("Creating request");
		GeocodingApiRequest req = GeocodingApi.newRequest(context).address(address + ", ");

		// Synchronous
		try {
			LOG.info("Sending request");
			GeocodingResult[] geocodingResultArray = req.await();
			LOG.info("Result received");
			// Handle successful request.
			LOG.info(geocodingResultArray[0].formattedAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
