package com.skilldistillery.jets.app;

import java.util.List;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetApplication {
	private static JetApplication jetApp = new JetApplication();
	private Scanner sc = new Scanner(System.in);
	private AirField airField = new AirField();

	private String fileName = "jet.txt";

	public static void main(String[] args) {
		jetApp.launch();
	}

	public void launch() {
		System.out.println("Welcome to the Hunter Army Airfield/ Mid-South Civilian Airport!");
		System.out.println();
		System.out.println("Please use the corresponding number to the menu item to navigate your visit.");

		List<Jet> fleet = airField.readJets(fileName);
		airField.setFleet(fleet);

		displayUserMenu();
	}

	protected void displayUserMenu() {
		boolean keepRunning = true;

		while (keepRunning) {
			System.out.println("1. List Fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jets");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");
			System.out.println();

			int selection = sc.nextInt();
			sc.nextLine(); 

			switch (selection) {
			case 1:
				List<Jet> fleet = airField.getFleet();
				for (Jet jet : fleet) {
					System.out.println(jet);
				}
				break;

			case 2:
				airField.fly();
				break;
			case 3:
				airField.fastestJet();
				break;
			case 4:
				airField.longestRangeJet();
				break;
			case 5:
				airField.loadAllCargo();
				break;
			case 6:
				airField.letsFight();
				break;
			case 7:
				airField.addJet();
				break;
			case 8:
				airField.removeJet();
				break;
			case 9:
				keepRunning = false;
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
				break;
			}
		}

		System.out.println("Goodbye!");
	}
}
