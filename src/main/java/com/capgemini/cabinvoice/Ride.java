package com.capgemini.cabinvoice;

public class Ride {

	public double distance;
	public int timeInMinute;
	public RideCategory rideCategory;

	public Ride(double distance, int timeInMinute, RideCategory rideCategory) {
		super();
		this.distance = distance;
		this.timeInMinute = timeInMinute;
		this.rideCategory = rideCategory;
	}
}