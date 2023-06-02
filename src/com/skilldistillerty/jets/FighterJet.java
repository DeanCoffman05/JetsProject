package com.skilldistillerty.jets;

public abstract class FighterJet extends Jet {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		model = "F35";
		speed = 1200;
		range = 1900;
		price = 70000000;
	}

	public abstract void fight();
}
