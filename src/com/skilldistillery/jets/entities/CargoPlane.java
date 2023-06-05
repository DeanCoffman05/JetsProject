package com.skilldistillery.jets.entities;

public  class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	public boolean loadCargo() {
		System.out.println("BIG and SLOW is how we GO! ");
		return true;
	}

}