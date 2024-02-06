package main.manager;

import main.gui.ElfController;
import main.gui.WichtelController;
import main.gui.StockSimulator;
import main.gui.Util;
import main.stock.Stack;

public class StockManager {

	public static final int NUMBEROFWICHTEL = 1;
	public static final int NUMBEROFELF = 1;

	public static final int NUMBEROFSTACKS = 20;
	public static final int STACKHEIGHT = 3;
	public static final int WIDTH = 10;

	/**
	 * Simulation running
	 */
	private static boolean running = true;

	/**
	 * Starts Manager.
	 * @param args - not defined yet
	 */
	public static void main(String[] args) {
		
		//Create some empty stacks(slots).
		Stack[] stacks = new Stack[NUMBEROFSTACKS];
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = new Stack();
		}
		
		//Create a manager for incoming pallets.
		IncomingPalletManager incomingPalletManager = new IncomingPalletManager();
		
		//Add some Wichtel
		for (int i = 0; i < NUMBEROFWICHTEL; i++) {
			new WichtelController(incomingPalletManager, stacks);
		}

		//Add some Elf
		for (int i = 0; i < NUMBEROFELF; i++) {
			new ElfController(incomingPalletManager, stacks);
		}
		
		//Run user interface
		StockSimulator sim = new StockSimulator(incomingPalletManager, stacks);
		
		while (running) {		
			sim.UpdateGUI();
			WichtelController.performWichtelOperationForEveryWichtel();
			ElfController.performElfOperationForEveryElf();
			Util.sleep(50);
		}		
	}
	
	/**
	 * Stops simulation
	 */
	public static void stop() {
		running = false;
	}
	}
