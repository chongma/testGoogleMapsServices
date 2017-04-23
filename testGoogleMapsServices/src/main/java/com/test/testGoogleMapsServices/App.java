package com.test.testGoogleMapsServices;

import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		App app = new App();
		app.updateLatLng("London");
	}

	public void updateLatLng(String address) {
		String googleMapsKey = "your key";

		GeoApiContext context = new GeoApiContext(new GaeRequestHandler()).setApiKey(googleMapsKey);
		System.out.println(googleMapsKey);
		GeocodingApiRequest req = GeocodingApi.newRequest(context).address(address + ", ");

		// Synchronous
		try {
			GeocodingResult[] geocodingResultArray = req.await();
			// Handle successful request.
			System.out.println(geocodingResultArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Synchronous ignore error
		// req.awaitIgnoreError(); // No checked exception.

		// Async
		// req.setCallback(new PendingResult.Callback<GeocodingResult[]>() {
		// @Override
		// public void onResult(GeocodingResult[] geocodingResultArray) {
		// // Handle successful request.
		// System.out.println(geocodingResultArray.length);
		// }
		//
		// @Override
		// public void onFailure(Throwable e) {
		// // Handle error.
		// System.out.println("ERROR");
		// }
		// });
	}
}
