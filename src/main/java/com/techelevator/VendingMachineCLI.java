package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static Purchase purchase = new Purchase();
	private Menu menu;

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		//import file
		File file = new File("D:\\Chris\\Workspace\\Vending-Machine-Practice\\vendingmachine.csv");
		purchase.createMap(file);

		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		boolean isRunning = true;

		while (isRunning) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println();
				purchase.displayVendingItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println();
				purchase.displayPurchaseMenu();

			}else if(choice.equals(MAIN_MENU_OPTION_EXIT)){
				// exit
				System.out.println();
				System.out.println("Goodbye!");
				isRunning = false;
				System.exit(1);
			}
		}

	}

}
