package com.skilldistillerty.jets;

public abstract class Jet {
	protected String model; 
	protected double speed;
	protected int range;
	protected long price;
	
	public Jet(String model, double speed, int range, long price) {
		this.model= model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	public void fly() {
		
		
	}
	public double getSpeedInMach(double speed) {
		speed = 0.0;
		return speed;
		
	}
}