package com.capgemini.cabinvoice;

public class CabInvoice {
	public final int COST_PER_MIN = 1;
	public final int COST_MIN = 5;
	public final int COST_PER_KM = 10;
	RideRepository rideRepository;

	public CabInvoice() {
		this.rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, double time) {
		double fare = distance * COST_PER_KM + time * COST_PER_MIN;
		return Math.max(fare, COST_MIN);
	}

	public InvoiceSummary calculateFare(Ride[] ride) {
		double totalFare = 0;
		for (Ride rides : ride)
			totalFare += this.calculateFare(rides.distance, rides.timeInMinute);
		return new InvoiceSummary(ride.length, (int) totalFare);
	}

	public void addRides(String userId, Ride[] ride) {
		rideRepository.addRide(userId, ride);

	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}