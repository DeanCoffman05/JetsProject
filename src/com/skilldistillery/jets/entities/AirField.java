package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	protected List<Jet> fleet;
	protected static String fileName;
	Scanner sc = new Scanner(System.in);

	public AirField() {
		fileName = "jets.txt";
		fleet = new ArrayList<>();
	}

	public List<Jet> readJets(String fileName) {
		fileName = "jets.txt";
		List<Jet> fleet = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fleetRecord = line.split(",");

				String model = fleetRecord[0];
				double speed = Double.parseDouble(fleetRecord[1]);
				int range = Integer.parseInt(fleetRecord[2]);
				long price = Long.parseLong(fleetRecord[3]);
				if (model.charAt(0) == 'F') {
					FighterJet j = new FighterJet(model, speed, range, price);
					fleet.add(j);
				} else if (model.charAt(0) == 'A') {
					fleet.add(new CargoPlane(model, speed, range, price));
				} else if (model.charAt(0) == 'P') {
					fleet.add(new JetImpl(model, speed, range, price));
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return fleet;

	}

	public void fly() {
		List<Jet> fleet = readJets(fileName);
		for (Jet jet : fleet)
			if (jet != null) {
				System.out.println(jet + "Is in the Air!");
				double speed = jet.getSpeed();
				int range = jet.getRange();
				long timeInAir = (long) (range / speed);
				System.out.println("It will be in the air for approximately " + timeInAir + " hours at full speed!");
			}
	}

	public void fastestJet() {

		List<Jet> fleet = readJets(fileName);
		Jet fastest = null;
		for (Jet jet : fleet) {
			if (jet != null) {
				if (fastest == null || jet.getSpeed() > fastest.getSpeed()) {
					fastest = jet;
				}
			}
		}
		if (fastest != null) {
			System.out.println(fastest + " is the fastest JET, ZOOOOM!");
		} else {
			System.out.println("THE FLEET IS EMPTY GET TO WORK!");
		}
	}

	public void longestRangeJet() {

		List<Jet> fleet = readJets(fileName);
		Jet range = null;
		for (Jet jet : fleet) {
			if (jet != null) {
				if (range == null || jet.getRange() > range.getRange()) {
					range = jet;
				}
			}
		}
		if (range != null) {
			System.out.println(range + " is in for the LONG HAUL with the longest RANGE!");
		} else {
			System.out.println("THE FLEET IS EMPTY GET TO WORK!");
		}
	}

	public void loadAllCargo() {
		List<Jet> fleet = readJets(fileName);
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				CargoPlane cargoPlane = (CargoPlane) jet;
				System.out.println(jet + " " + cargoPlane.loadCargo());
			}
		}
	}

	public void letsFight() {
		List<Jet> fleet = readJets(fileName);
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				FighterJet fighterJet = (FighterJet) jet;
				System.out.println(jet + " " + fighterJet.fight());
			}
		}
	}

	public void addJet() {
		System.out.println("Enter the model of the jet you would like to add.");
		String model = sc.next();

		System.out.println("Enter the speed of the jet.");
		Double speed = sc.nextDouble();

		System.out.println("Enter the range.");
		int range = sc.nextInt();

		System.out.println("Enter the price.");
		Long price = sc.nextLong();

		Jet jet = new JetImpl(model, speed, range, price);
		fleet.add(jet);

		System.out.println("Your jet has been added.");

	}

	public void removeJet() {
		
		System.out.println("Enter the model of the jet you would like to remove:");
		List<Jet> fleet = getFleet();
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
		String model = sc.next();

		boolean removed = false;

		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if (jet.getModel().equals(model)) {
				fleet.remove(i);
				removed = true;
				break;
			}
		}

		if (removed) {
			System.out.println(model + " has been removed.");
		} else {
			System.out.println("Error try again, please.");
		}

	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	public List<Jet> getFleet() {
		return fleet;
	}
}