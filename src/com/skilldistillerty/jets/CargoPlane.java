package com.skilldistillerty.jets;

public abstract class CargoPlane extends Jet {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		model = "C130";
		speed = 417;
		range = 2600;
		price = 75500000;
	}

	public abstract void loadCargo();

}