package com.skilldistillery.jets.entities;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected int range;
	protected long price;
	AirField airField = new AirField();
	String fileName = "jet.txt";
	double rangeSpeed;

	public Jet() {

	}

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public void rangeSpeed() {
		rangeSpeed = (this.range % this.speed);
	}

	@Override
	public String toString() {
		return "Jet [" + (model != null ? "model = " + model + ", " : "") + "speed = " + speed + ", range = " + range
				+ ", price=" + price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}