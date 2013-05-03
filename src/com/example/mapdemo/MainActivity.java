package com.example.mapdemo;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {
	private String provider = LocationManager.GPS_PROVIDER;
	private int t = 5000; // miliseconds
	private int distance = 5; // meters
	private TextView long_lat;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		final boolean gpsEnabled = loc
				.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (!gpsEnabled) {
			Toast.makeText(this, "GPS is NOT enabled ", Toast.LENGTH_SHORT)
					.show();

		} else {
			Toast.makeText(this, "OK ", Toast.LENGTH_SHORT).show();
		}
		loc.requestLocationUpdates(provider, t, distance, this);

	}

	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		if (loc != null) {
			double lat = loc.getLatitude();
			double lng = loc.getLongitude();
			TextView long_lat = (TextView) findViewById(R.id.long_lat);
			long_lat.setText("Longitude: " + lng + " | " + "Latitude: " + lat);
		} else {
			long_lat.setText("No location found!");
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
