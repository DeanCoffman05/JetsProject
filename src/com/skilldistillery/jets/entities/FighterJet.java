package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady  {

   protected FighterJet() {
	   
   }

	protected FighterJet(String model, double speed, int range, long price) {
		this.model= model;
		this.speed= speed;
		this.range= range;
		this.price= price;
	}

	public boolean fight() {
		System.out.println("I am fighter jet hear me fight!");
		return true;
	}



}
